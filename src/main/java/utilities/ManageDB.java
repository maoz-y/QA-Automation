package utilities;

import java.sql.DriverManager;
import java.sql.SQLException;


public class ManageDB extends CommonOps {

    /*
    ###################################################################
    Method Name: open connection
    Method Description:this method open the connection in Data Base
    Method Parameters:String
    Method Return:
    ###################################################################
    */
    public static void openConnection(String dbURL, String user, String pass) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(dbURL, user,  pass);
            stmt = con.createStatement();
        } catch (Exception e) {
            System.out.println("Error occurred while connecting DB, see details " + e);
        }
    }

    /*
    ######################################################################
    Method Name: Close Connection
    Method Description:this method is closing the connection in Data Base
    Method Parameters:
    Method Return:
    ######################################################################
    */
    public static void closeConnection() {
        try {
            con.close();
        } catch (Exception e) {
            System.out.println("Error occurred while closing DB, see details " + e);
        }
    }

}
