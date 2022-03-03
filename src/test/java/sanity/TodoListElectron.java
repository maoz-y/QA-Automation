package sanity;

import com.sun.org.glassfish.gmbal.Description;
import extenssion.Verification;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.ElectronFlows;

@Listeners(utilities.Listeners.class)


public class TodoListElectron extends CommonOps {

    @Test(description = "test 01 - Add and verify new task")
    @Description("This test is adds a new task and verifies it in the list of tasks")
    public  void test01_addAndVerifyNewTask() {
        ElectronFlows.addnewtask("Learn QA");
        Verification.verifyNumber(ElectronFlows.getnumberoftasks(), 1);
    }

    @Test(description = "test 02 - Add and verify new tasks")
    @Description("This test is adds a new task and verifies it in the list of tasks")
    public  void test02_addAndVerifyNewTasks() {
        ElectronFlows.addnewtask("Learn QA");
        ElectronFlows.addnewtask("Learn Java");
        ElectronFlows.addnewtask("Learn Paython");
        Verification.verifyNumber(ElectronFlows.getnumberoftasks(), 3);
    }
}
