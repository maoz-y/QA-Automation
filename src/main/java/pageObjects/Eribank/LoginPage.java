package pageObjects.Eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private AppiumDriver mobileDriver;
    public LoginPage (AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
       // PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "usernameTextField")
    public MobileElement txt_userName;

    @AndroidFindBy(id = "passwordTextField")
    public MobileElement txt_password;

    @AndroidFindBy(id = "loginButton")
    public MobileElement btn_login;
}
