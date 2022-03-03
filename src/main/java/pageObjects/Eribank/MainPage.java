package pageObjects.Eribank;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

public class MainPage {
    private AppiumDriver mobileDriver;
    public MainPage (AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
      //  PageFactory.initElements(new AppiumFieldDecorator(mobileDriver, 3, TimeUnit.SECONDS), this);
    }

    @AndroidFindBy(id = "makePaymentButton")
    public MobileElement btn_makePayment;

}
