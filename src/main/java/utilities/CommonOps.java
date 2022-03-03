package utilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.restassured.RestAssured;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;
import workflows.ElectronFlows;
import workflows.WebFlows;
import java.lang.reflect.Method;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base {

    /*
    ###################################################################
    Method Name: get Data
    Method Description:this method gets data from an external xml file
    Method Parameters:string
    Method Return:string
    ###################################################################
    */
    public static String getData(String nodeName)
    {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dbuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");
            dbFactory = DocumentBuilderFactory.newInstance();
            dbuilder =dbFactory.newDocumentBuilder();
            doc = dbuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();

        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    /*
    ############################################################################
    Method Name: init Browser
    Method Description: this method initialize a browser from the options inside
    Method Parameters: string
    Method Return: void
    ###########################################################################
    */
    public static void initBrowser(String browserType) {
        if (browserType.equalsIgnoreCase("chrome"))
            driver = initChromeDriver();
        else if (browserType.equalsIgnoreCase("firefox"))
            driver = initFirefoxDriver();
        else if (browserType.equalsIgnoreCase("ie"))
            driver = initIEDriver();
        else throw new RuntimeException("Invalid Browser Type");

        ManagePages.initParabank();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.get(getData("url"));
        WebFlows.initialize();
        action = new Actions(driver);


    }

     /*
    ###################################################################
    Method Name: init Chrome Driver
    Method Description:this method initialize the Chrome driver
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    public static WebDriver initChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        return driver;
    }

     /*
    ###################################################################
    Method Name: init FireFox
    Method Description:this method initialize the Fire Fox driver
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    public static WebDriver initFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        return driver;
    }

    /*
    #######################################################################
    Method Name: init IE river
    Method Description:this method initialize the Internet Explorer driver
    Method Parameters:
    Method Return: void
    #######################################################################
    */
    public static WebDriver initIEDriver() {
        WebDriverManager.iedriver().setup();
        WebDriver driver = new InternetExplorerDriver();
        return driver;
    }

    /*
   ###################################################################
   Method Name: init Mobile
   Method Description:this method initialize the Mobile driver
   Method Parameters:
   Method Return: void
   ###################################################################
   */
    public static void initMobile() {
        dc.setCapability(MobileCapabilityType.UDID, getData("UDID"));
        dc.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, getData("APP_PACKAGE"));
        dc.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, getData("APP_ACTIVITY"));
        try {
            mobileDriver = new AndroidDriver<>(new URL(getData("AppiumServer")), dc);
        } catch (Exception e) {
            System.out.println("Can not connect to appium server, see detailes: " + e);
        }
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Long.parseLong(getData("Timeout")));
        ManagePages.initEribank();
        action = new Actions(driver);

    }

    /*
    ###################################################################
    Method Name: init Api
    Method Description:this method initialize Api
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    public static void initAPI() {
        RestAssured.baseURI = getData("urlAPI");
        httpRequest = RestAssured.given();
    }

    /*
    ###################################################################
    Method Name: init Electron
    Method Description:this method initialize the Electron driver
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    public static void initElectron() {
        System.setProperty("webdriver.chrome.driver", getData("ElectronDriverPath"));
        ChromeOptions opt = new ChromeOptions();
        opt.setBinary(getData("ElectronAppPath"));
        dc.setCapability("chromeOptions", opt);
        dc.setBrowserName("chrome");
        driver = new ChromeDriver(dc);
        ManagePages.initTodo();
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        action = new Actions(driver);

    }

    /*
    ###################################################################
    Method Name: init Desktop
    Method Description:this method initialize the Desktop driver
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    public static void initDesktop() {
        dc.setCapability("app", getData("CalculatorApp"));
        try {
            driver = new WindowsDriver(new URL(getData("AppiumServerDesktop")),dc);
        } catch (Exception e) {
            System.out.println("Cannot connect to Appium server, see details" + e);
        }
        wait = new WebDriverWait(driver, Long.parseLong(getData("Timeout")));
        driver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")),TimeUnit.SECONDS);
       // action = new Actions(driver);
        ManagePages.initCalculator();
    }

    /*
    ###################################################################
    Method Name: start Session
    Method Description:this method Runs before all classes
    Method Parameters: String
    Method Return: void
    ###################################################################
    */
    @BeforeClass
    @Parameters({"PlatformName"})
    public void startSession(String PlatformName) {
        platform = PlatformName;
        if (platform.equalsIgnoreCase("web"))
            initBrowser(getData("BrowserName"));
        else if (platform.equalsIgnoreCase("mobile"))
            initMobile();
        else if (platform.equalsIgnoreCase("api"))
            initAPI();
        else if (platform.equalsIgnoreCase("electron"))
            initElectron();
        else if (platform.equalsIgnoreCase("desktop"))
            initDesktop();
        else
            throw new RuntimeException("Invalid Platform Name");

        softAssert = new SoftAssert();
        screen = new Screen();
        ManageDB.openConnection(getData("DBURL"), getData("DBUserName"), getData("DBPassword"));

    }

    /*
    ###################################################################
    Method Name: end Session
    Method Description:this method Runs after all classes
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    @AfterClass
    public void endsession() {
        ManageDB.closeConnection();
        if (!platform.equalsIgnoreCase("api")) {
            if (!platform.equalsIgnoreCase("mobile"))
                driver.quit();
            else
                mobileDriver.quit();
        }

    }

     /*
    ###################################################################
    Method Name: Before Method
    Method Description:this method Runs befor all methods
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    @BeforeMethod
    public void beforeMethod(Method method) {
        if (!platform.equalsIgnoreCase("api"))
        try {
            MonteScreenRecorder.startRecord(method.getName());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

     /*
    ###################################################################
    Method Name: after Method
    Method Description:this method Runs after all methods
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    @AfterMethod
    public void aftermethod() {
        if (platform.equalsIgnoreCase("web"))
        driver.get(getData("url"));
        else if (platform.equalsIgnoreCase("electron"))
            ElectronFlows.deletelist();
    }
}
