package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extenssion.Verification;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.MobileFlows;

@Listeners(utilities.Listeners.class)

public class EribankMobile extends CommonOps {

    @Test(description = "Test01-Login Eribank App")
    @Description("This test is Logs in to the app, fills out a form and checks payment ")
    public  void test01_LoginEribank() {
        MobileFlows.eribankLogin("company", "company");
        MobileFlows.eribankPayment("050-8224558", "Maoz", "200");
        Verification.verifyTextinElement(eribankpayment.paymen_result, "Your balance is: -100.00$");
    }
}
