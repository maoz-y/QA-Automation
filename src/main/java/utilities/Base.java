package utilities;

import io.appium.java_client.AppiumDriver;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class Base {

    //General
    protected static WebDriverWait wait;
    protected static Actions action;
    public static SoftAssert softAssert;
    protected static Screen screen;
    protected static String platform;

    //Web
    protected static WebDriver driver;

    //Mobile
    protected static AppiumDriver mobileDriver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();


    //REST API
    protected static RequestSpecification httpRequest;
    protected static Response response;
    protected static JSONObject params = new JSONObject();
    protected static JsonPath jp;

    //DATA BASE
    protected static Connection con;
    protected static Statement stmt;
    protected static ResultSet rs;


    //Page Objects Web
    protected static pageObjects.Parabank.LoginPage parabanklogin;
    protected static pageObjects.Parabank.MainPage parabankmain;
    protected static pageObjects.Parabank.AdminPage parabankadmin;
    protected static pageObjects.Parabank.LeftPanelPage parabankleftpanel;
    protected static pageObjects.Parabank.OpenNewAccountPage parabankopennewaccount;
    protected static pageObjects.Parabank.TransferFoundsPage parabanktransferfounds;
    protected static pageObjects.Parabank.RequestLoanPage parabankrequestloan;

    //Page Objects Mobile
    protected static pageObjects.Eribank.LoginPage eribanklogin;
    protected static pageObjects.Eribank.MainPage eribankmain;
    protected static pageObjects.Eribank.PaymentPage eribankpayment;

    //Page Objects Electron
    protected static pageObjects.Todo.MainPage todomain;

    //Page Objects Desktop
    protected static pageObjects.Calculator.MainPage calcmain;








}
