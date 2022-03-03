package extenssion;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.sikuli.script.FindFailed;
import utilities.CommonOps;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class Verification extends CommonOps {

    @Step("Verify Text in Element")
    public static void verifyTextinElement(WebElement elem, String expected) {
        assertEquals(elem.getText(), expected);
    }

    @Step("Visibility of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems) {
        for (WebElement elem : elems) {
            softAssert.assertTrue(elem.isDisplayed(),"sorry" + elem.getText()+"not displayed");
        }
        softAssert.assertAll("Some Elements were not Displayed");
    }

    @Step("Verify Element Visually ")
    public static void visualElement(String expectedImageName ) {
        try {
            screen.find(getData("ImageRepo")+expectedImageName+ ".png");
        } catch (FindFailed findFailed) {
            System.out.println("Error Comparing image File" + findFailed);
            fail("Error Comparing image File" + findFailed);
        }
    }
    //Api
    @Step("Verify Text with Text")
    public static void verifyText(String actual, String expected) {
        assertEquals(actual, expected);
    }

    @Step("Verify Number with Number")
    public static void verifyNumber(int actual, int expected) {
        assertEquals(actual, expected);
    }


}
