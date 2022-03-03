package workflows;

import extenssion.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class DesktopFlows extends CommonOps {

    @Step("Calculate Addition 1+7")
    public static void calculateaddition() {
        UIActions.click(calcmain.btn_clear);
        UIActions.click(calcmain.btn_1);
        UIActions.click(calcmain.btn_plus);
        UIActions.click(calcmain.btn_7);
        UIActions.click(calcmain.btn_equals);
    }

    @Step("Calculate multiplication 9*9")
    public static void calculatemultiplication() {
        UIActions.click(calcmain.btn_clear);
        UIActions.click(calcmain.btn_nine);
        UIActions.click(calcmain.btn_multiply);
        UIActions.click(calcmain.btn_nine);
        UIActions.click(calcmain.btn_equals);
    }
}
