package utilities;

import org.openqa.selenium.support.PageFactory;

public class ManagePages extends Base {
    /*
    ###################################################################
    Method Name: init parabank
    Method Description:this method initialize the parabank App pages
    Method Parameters:
    Method Return: void
    ###################################################################
    */
    public static void initParabank() {
        parabanklogin = PageFactory.initElements(driver, pageObjects.Parabank.LoginPage.class);
        parabankmain = PageFactory.initElements(driver, pageObjects.Parabank.MainPage.class);
        parabankadmin = PageFactory.initElements(driver, pageObjects.Parabank.AdminPage.class);
        parabankleftpanel = PageFactory.initElements(driver, pageObjects.Parabank.LeftPanelPage.class);
        parabankopennewaccount = PageFactory.initElements(driver, pageObjects.Parabank.OpenNewAccountPage.class);
        parabanktransferfounds = PageFactory.initElements(driver, pageObjects.Parabank.TransferFoundsPage.class);
        parabankrequestloan = PageFactory.initElements(driver, pageObjects.Parabank.RequestLoanPage.class);

    }

     /*
    #######################################################################
    Method Name: init Eribank
    Method Description:this method initialize the Eribank app pages (Mobile)
    Method Parameters:
    Method Return: void
    ########################################################################
    */
    public static void initEribank() {
        eribanklogin = new pageObjects.Eribank.LoginPage(mobileDriver);
        eribankmain = new pageObjects.Eribank.MainPage(mobileDriver);
        eribankpayment = new pageObjects.Eribank.PaymentPage(mobileDriver);

    }

     /*
    ######################################################################
    Method Name: init Todo
    Method Description:this method initialize the Todo app page (Electron)
    Method Parameters:
    Method Return: void
    ######################################################################
    */
    public static void initTodo() {
        todomain =  PageFactory.initElements(driver, pageObjects.Todo.MainPage.class);
    }

     /*
    ###########################################################################
    Method Name: init Calculator
    Method Description:this method initialize the Calculator app page (desktop)
    Method Parameters:
    Method Return: void
    ##########################################################################
    */
    public static void initCalculator() {
        calcmain =  PageFactory.initElements(driver, pageObjects.Calculator.MainPage.class);
    }

}
