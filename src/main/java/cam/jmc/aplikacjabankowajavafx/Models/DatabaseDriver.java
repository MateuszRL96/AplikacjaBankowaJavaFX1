package cam.jmc.aplikacjabankowajavafx.Models;


import java.sql.*;
import java.time.LocalDate;

public class DatabaseDriver {
    private Connection conn;

    public DatabaseDriver() {
        try {
            // Tworzenie połączenia z bazą danych SQLite
            this.conn = DriverManager.getConnection("jdbc:sqlite:proba.db");

            System.out.println("Połączono z bazą danych SQLite!");

        } catch (SQLException e) {
            //System.err.println(e.getMessage());
            System.out.println("Bład1");
        }
    }

    public ResultSet getClientData(String pAddress, String password) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress='"+pAddress+"' AND Password='"+password+"';");
        }catch (SQLException e){
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








