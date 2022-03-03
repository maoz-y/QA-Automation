package workflows;

import extenssion.UIActions;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import utilities.CommonOps;

public class ElectronFlows extends CommonOps {

    @Step("Add New Task To The List")
    public static void addnewtask(String taskname) {
        UIActions.updateText(todomain.txt_create, taskname);
        UIActions.insertkey(todomain.txt_create, Keys.RETURN);
    }

    @Step("Count and Return Number Of Tasks In List")
    public static int getnumberoftasks() {
        return todomain.list_tasks.size();
    }

    @Step("Delete tasks from list")
    public static void deletelist() {
        for (int i=0 ; i<getnumberoftasks() ; i++){
        UIActions.mousehover(todomain.btn_delete);
    }
    }

}
