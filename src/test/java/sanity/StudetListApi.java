package sanity;

import extenssion.Verification;
import io.qameta.allure.Description;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ApiFlows;


@Listeners(utilities.Listeners.class)

public class StudetListApi extends CommonOps {

    @Test(description = "test01-Verify Student")
    @Description("This Test Verifies Student Property")
    public void test01_verifyStudent() {
        Verification.verifyText(ApiFlows.getStudentProperty("[0].firstName"),"Vernon" );
    }

    @Test(description = "test02-Add Student")
    @Description("This Test Add a student to the list and verify it")
    public void test02_AddStudentAndVerify() {
        ApiFlows.postStudent("Maoz","Yehuda", "maoz@gmail.com","QA");
        Verification.verifyText(ApiFlows.getStudentProperty("[100].firstName"),"Maoz" );
    }

    @Test(description = "test03- update Student")
    @Description("This Test Update student and verify it")
    public void test03_UpdateDtudentAndVerify() {
        String id = ApiFlows.getStudentProperty("[100].id");
        ApiFlows.updateStudent("Maoz", "Yehuda","maoz@gmail.com", "Java", id);
        Verification.verifyText(ApiFlows.getStudentProperty("[100].programme"),"Java");
    }

    @Test(description = "test04- Delete Student")
    @Description("This Test Delete student from list")
    public void test04_DeleteStudent() {
       String id = ApiFlows.getStudentProperty("[100].id");
       ApiFlows.delete(id);
    }

}
