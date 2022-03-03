package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extenssion.DBActions;
import extenssion.UIActions;
import io.qameta.allure.Step;
import utilities.CommonOps;

import java.util.List;

public class WebFlows extends CommonOps {

    @Step("Business Flow: Login to Parabank")
    public static void login(String user, String pass){
        UIActions.updateText(parabanklogin.txt_username, user);
        UIActions.updateText(parabanklogin.txt_password, pass);
        UIActions.click(parabanklogin.btn_login);
    }

    @Step("Business Flow: Login to Parabank with Data Base")
    public static void loginDB() {
        String query = "SELECT username, password FROM loginPB WHERE id='3'";
        List<String> cred = DBActions.getCredentials(query);
        UIActions.updateText(parabanklogin.txt_username, cred.get(0));
        UIActions.updateText(parabanklogin.txt_password,cred.get(1));
        UIActions.click(parabanklogin.btn_login);
    }

    @Step("Business Flow: Initialize site")
    public static void initialize() {
        UIActions.click(parabankmain.btn_admin);
        UIActions.click(parabankadmin.btn_initialization);
    }

    @Step("Business Flow: Open New Account")
    public static void openNewAccount(String text, int index) {
        UIActions.click(parabankleftpanel.btn_newAccount);
        UIActions.updateDropdown(parabankopennewaccount.DD_accountType, text);
        UIActions.updateDropdownByIndex(parabankopennewaccount.DD_fromAccount, index);
        UIActions.click(parabankopennewaccount.btn_openAccount);
    }

    @Step("Business Flow: Tranfer Founds")
    public static void transferFounds(String textAmount, int indexFrom, int indexTo) {
        UIActions.click(parabankleftpanel.btn_transferFounds);
        UIActions.updateText(parabanktransferfounds.txt_amount, textAmount);
        UIActions.updateDropdownByIndex(parabanktransferfounds.DD_fromAccount, indexFrom);
        UIActions.updateDropdownByIndex(parabanktransferfounds.DD_toAccount, indexTo);
        UIActions.click(parabanktransferfounds.btn_transfer);
    }

    @Step("Business Flow: Request Loan")
    public static void requestloan (String loanamount, String downpayment) {
        UIActions.click(parabankleftpanel.btn_requestLoan);
        UIActions.updateText(parabankrequestloan.txt_amount, loanamount);
        UIActions.updateText(parabankrequestloan.txt_downPayment, downpayment);
        UIActions.click(parabankrequestloan.btn_apply);
    }

}
