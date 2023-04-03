package cam.jmc.aplikacjabankowajavafx.Models;

import java.sql.*;


public class DatabaseDriver
{
   private Connection conn;
    private static final String url = "jdbc:mysql://localhost:3306/bankapp";
    private static final String user = "root";
    private static final String password = "1234";

    public ResultSet getClientData(String pAddress, String password)
    {
        Statement statement;
        ResultSet resultSet = null;
        try
        {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress= ' "+pAddress+"' AND Password = '" + password+"';");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }
}










