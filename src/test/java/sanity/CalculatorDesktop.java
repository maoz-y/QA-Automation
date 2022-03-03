package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extenssion.Verification;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.DesktopFlows;


@Listeners(utilities.Listeners.class)

public class CalculatorDesktop extends CommonOps {

    @Test(description = "test01-verify Addition command")
    @Description("This test verifies the addition command")
    public  void test01_verifyadditioncommand() {
        DesktopFlows.calculateaddition();
        Verification.verifyTextinElement(calcmain.filed_result, "Display is 8");
    }

    @Test(description = "test02-verify Multiplication command")
    @Description("This test verifies the addition command")
    public  void test02_verifymultiplicationcommand() {
        DesktopFlows.calculatemultiplication();
        Verification.verifyTextinElement(calcmain.filed_result, "Display is 81");
    }

}
