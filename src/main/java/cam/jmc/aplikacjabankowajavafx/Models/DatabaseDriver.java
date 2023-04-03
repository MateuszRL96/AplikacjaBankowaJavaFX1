package cam.jmc.aplikacjabankowajavafx.Models;

import java.sql.*;
import java.time.LocalDate;


public class DatabaseDriver
{
    public Connection conn;
    /*
    private static final String url = "jdbc:mysql://localhost:3306/bankapp";
    private static final String user = "";
    private static final String password = "";*/

    public DatabaseDriver()
    {
        try
        {
            this.conn = DriverManager.getConnection("jdbc:sqlite:asd.db");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
//"jdbc:mysql://localhost:3306/bankapp"
    public ResultSet getClientData(String pAddress, String password)
    {
        Statement statement;
        ResultSet resultSet = null;
        try
        {
            statement = this.conn.createStatement();
            //resultSet = statement.executeQuery("SELECT * FROM clients WHERE PayeeAddress='"+pAddress+"' AND Password='" + password+"';");
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password='"+password+"';");

        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }



    //------------------------------------- A D M I N -------- S E C T I O N --------------------------------------------------->

    public ResultSet getAdminData(String username, String password)
    {
        Statement statement;
        ResultSet resultSet = null;
        try
        {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM admins WHERE Username='"+username+"' AND Password='"+password+"';");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }


}













