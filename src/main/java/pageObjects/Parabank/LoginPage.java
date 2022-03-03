package pageObjects.Parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    @FindBy(how = How.XPATH, using = "//*[@id='loginPanel']/form/div[1]/input")
    public WebElement txt_username;

    @FindBy(how = How.XPATH, using = "//*[@id='loginPanel']/form/div[2]/input")
    public WebElement txt_password;

    @FindBy(how = How.CSS, using = "input[type='submit']")
    public WebElement btn_login;



}
