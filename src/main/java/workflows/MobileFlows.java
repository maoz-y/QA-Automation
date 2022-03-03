package workflows;

import extenssion.MobileActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

public class MobileFlows extends CommonOps {

    @Step("Business Fllows: Login Eribank App")
    public static void eribankLogin(String userName, String password) {
        MobileActions.updateText(eribanklogin.txt_userName, userName);
        MobileActions.updateText(eribanklogin.txt_password, password);
        MobileActions.tap(1,eribanklogin.btn_login,500);
    }

    @Step("Business Fllows: Make Payment")
    public static void eribankPayment(String phone, String name, String amount) {
     MobileActions.tap(1,eribankmain.btn_makePayment, 500);
     MobileActions.updateText(eribankpayment.txt_phone, phone);
     MobileActions.updateText(eribankpayment.txt_name, name);
     MobileActions.updateText(eribankpayment.txt_amount, amount);
     MobileActions.tap(1, eribankpayment.btn_selectCountry, 500);
     MobileActions.tap(1, eribankpayment.btn_india, 500);
     MobileActions.tap(1, eribankpayment.btn_sendPaymet, 500);
     MobileActions.tap(1, eribankpayment.btn_confirm, 500);
    }
}
