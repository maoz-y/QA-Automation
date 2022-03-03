package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extenssion.Verification;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


@Listeners(utilities.Listeners.class)

public class ParabankWebDB extends CommonOps {
    @Test(description = "test01-verify Login with DB Credentials")
    @Description("This test is login to Parabank with BD Credentials")
    public  void test01_loginDBandVerifyHeader() {
        WebFlows.loginDB();
        Verification.verifyTextinElement(parabankmain.cuostumer_messege,"Welcome John Smith");
    }
}
