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
    //------------------------------------- A D M I N -- S E C T I O N ------------------------------------------------>

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

    public void createClient(String firstName, String lastName, String pAddress, String password, LocalDate date) {
        Statement statement;
        try{
            statement = this.conn.createStatement();
            statement.executeUpdate("INSERT INTO " +
                    "Clients (FirstName, LastName, PayeeAddress, Password, Date)" +
                    "VALUES ('"+firstName+"', '"+lastName+"', '"+pAddress+"', '"+password+"', '"+date.toString()+"');");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createCheckingAccount(String owner, String number, double tLimit, double balance) {
        Statement statement;
        try{
            statement = this.conn.createStatement();
            statement.executeUpdate("INSERT INTO " +
                    "CheckingAccounts (Owner, AccountNumber, TransactionLimit, Balance)" +
                    "VALUES ('"+owner+"', '"+number+"', '"+tLimit+"', '"+balance+"');");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void createSavingsAccount(String owner, String number, double wLimit, double balance) {
        Statement statement;
        try{
            statement = this.conn.createStatement();
            statement.executeUpdate("INSERT INTO " +
                    "SavingsAccounts (Owner, AccountNumber, WithdrawalLimit, Balance)" +
                    "VALUES ('"+owner+"', '"+number+"', '"+wLimit+"', '"+balance+"');");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }


    //-----------------------------------U T I L I T Y -- M E T H O D S ----------------------------------------------->

        public int getLastClientId() {
            Statement statement;
            ResultSet resultSet;
            int id = 0;
            try {
                statement = this.conn.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM sqlite_sequence WHERE name = 'Clients';");
                id = resultSet.getInt("seq");
            }
            catch (SQLException e){
                e.printStackTrace();
            }
            return id;
        }

}








