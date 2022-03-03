package sanity;

import extenssion.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;

@Listeners(utilities.Listeners.class)

public class ParabankWeb extends CommonOps {

    @Test(description = "test01-verify Header")
    @Description("This test is login and verifies custumer welcome message")
    public  void test01_verifyWelcomeMessage() {
        WebFlows.login("john", "demo");
        Verification.verifyTextinElement(parabankmain.cuostumer_messege,"Welcome John Smith");
    }

    @Test(description = "Test02-open New Account")
    @Description("This test checks that a new account has been successfully opened")
    public void test02_openNewAccount() {
        WebFlows.openNewAccount("CHECKING", 0);
        Verification.verifyTextinElement(parabankopennewaccount.accountIsOpened, "Congratulations, your account is now open.");
    }

    @Test(description = "test03-verify Service Buttons")
    @Description("This test checks that the service buttons are exist")
    public void test03_verifyServiceButtons() {
        Verification.visibilityOfElements(parabankmain.list_servicebuttons);
    }

    @Test(description = "test04-verify Avatar Icon")
    @Description("This test Verifies Avatar Image using Sikuli Tool")
    public void test04_verifyServiceButtons() {
        Verification.visualElement("Screenshot Avatar");
    }

    @Test(description = "test05-verify Transfer Founds")
    @Description("This test Verifies that Transfer is Done")
    public void test05_verifyTransferFounds() {
        WebFlows.transferFounds("200", 0, 0);
        Verification.verifyTextinElement(parabanktransferfounds.transferIsDone, "Transfer Funds");
    }

    @Test (description ="Test06- Vrify Request Loan", dataProvider = "Data Provider Amount",dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test Verifies Request Loan using DDT")
    public void test06_verifyrequestloan(String loanmount, String downpayment) {
        WebFlows.requestloan(loanmount, downpayment);
        Verification.verifyTextinElement(parabankrequestloan.txt_aprroveloan, "Congratulations, your loan has been approved.");
    }
}
