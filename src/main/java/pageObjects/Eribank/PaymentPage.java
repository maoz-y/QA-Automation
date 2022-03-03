package pageObjects.Eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class PaymentPage {

    private AppiumDriver mobileDriver;
    public PaymentPage (AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
       // PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "phoneTextField")
    public MobileElement txt_phone;

    @AndroidFindBy(id = "nameTextField")
    public MobileElement txt_name;

    @AndroidFindBy(id = "amountTextField")
    public MobileElement txt_amount;

    @AndroidFindBy(id = "countryButton")
    public MobileElement btn_selectCountry;

    @AndroidFindBy(xpath = "//*[@id='rowTextView']")
    public MobileElement btn_india;

    @AndroidFindBy(id = "sendPaymentButton")
    public MobileElement btn_sendPaymet;

    @AndroidFindBy(id = "button1")
    public MobileElement btn_confirm;

    @AndroidFindBy(xpath = "//*[@text='Your balance is: -100.00$']")
    public MobileElement paymen_result;

}
