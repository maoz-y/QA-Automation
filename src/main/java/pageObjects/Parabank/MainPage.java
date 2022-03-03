package pageObjects.Parabank;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class MainPage {

    @FindBy(how= How.XPATH, using="//div[@id='leftPanel']/p")
    public WebElement cuostumer_messege;

    @FindBy(how= How.LINK_TEXT, using="Admin Page")
    public WebElement btn_admin;

    @FindBy(how= How.XPATH, using="//div[@id='headerPanel']/ul[2]")
    public List<WebElement> list_servicebuttons;

}
