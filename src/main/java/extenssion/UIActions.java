package extenssion;

import com.sun.org.glassfish.external.probe.provider.annotations.ProbeListener;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.Base;
import utilities.CommonOps;

public class UIActions extends CommonOps {

    @Step("Click on Element")
    public static void click(WebElement elem) {
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }
    @Step("Update text Element")
    public static void updateText(WebElement elem, String text) {
        wait.until((ExpectedConditions.visibilityOf(elem)));
        elem.sendKeys(text);
    }
    @Step("Update DropDown")
    public static void updateDropdown(WebElement elem, String text) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    @Step("Update DropDown By Index")
    public static void updateDropdownByIndex(WebElement elem, int index) {
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByIndex(index);
    }

    @Step("Mouse hover Element")
    public static void mousehover(WebElement elem1, WebElement elem2) {
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

    //Method Overload
    @Step("Mouse hover Element")
    public static void mousehover(WebElement elem1) {
        action.moveToElement(elem1).click().build().perform();
    }

    @Step("Insert Key")
    public static void insertkey(WebElement elem, Keys value) {
        elem.sendKeys(value);
    }



}
