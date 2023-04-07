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



    //----------------------------------- C L I E N T -- S E C T I O N ------------------------------------------------>



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

    public ResultSet getTransactions(String pAddress, int limit){
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Transactions WHERE Sender='"+pAddress+"' OR Receiver='"+pAddress+"' LIMIT "+limit+";");
        }
        catch(SQLException e){
            //System.out.println("error");
             e.printStackTrace();
        }
        return resultSet;
    }

    //----------------------------------METHOD--RETURNS--SAVINGS--ACCOUNT--BALANCE ------------------------------------>

    public double getSavingsAccountBalance(String pAddress){
        Statement statement;
        ResultSet resultSet;
        double balance = 0;
        try{
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccount WHERE Owner ='"+pAddress+"';");
            balance = resultSet.getDouble("Balance");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return balance;
    }


    //---------------------METHOD--TO--EITHER--ADD--OR--SUBTRACT--FROM--BALANCE--GIVEN--OPERATION --------------------->

    public void updateBalance(String pAddress, double amount, String operation){
        Statement statement;
        ResultSet resultSet;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccounts WHERE Owner='"+pAddress+"';");
            double newBalance;
            if(operation.equals("ADD"))
            {
                newBalance = resultSet.getDouble("Balance") + amount;
                statement.executeUpdate("UPDATE SavingsAccounts SET Balance ="+newBalance+" WHERE Owner='"+pAddress+"';");
            }
            else
            {
                if(resultSet.getDouble("Balance") >= amount)
                {
                    newBalance = resultSet.getDouble("Balance") - amount;
                    statement.executeUpdate("UPDATE SavingsAccounts SET Balance ="+newBalance+" WHERE Owner='"+pAddress+"';");
                }
            }
            //statement.executeUpdate("UPDATE SavingsAccounts SET Balance ="+newBalance+" WHERE Owner='"+pAddress+"';");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    //----------------------------------CREATE--AND--RECORDS--NEW--TRANSACTION----------------------------------------->

    public void newTransaction(String sender, String receiver, double amount, String message){
        Statement statement;
        try {
            statement = this.conn.createStatement();
            LocalDate date = LocalDate.now();
            statement.executeUpdate("INSERT INTO " +
                    "Transaction(Sender, Receiver, Amount, Date, Message) " +
                    "VALUES ('"+sender+"', '"+receiver+"', '"+amount+"', '"+date+"', '"+message+"',");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
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

    public ResultSet getAllClientsData() {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients;");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }



    public void depositSavings(String pAddress, double amount) {
        Statement statement;
        try {
            statement = this.conn.createStatement();
            statement.executeUpdate("UPDATE SavingsAccounts SET Balance="+amount+" WHERE Owner='"+pAddress+"';");
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }



    //-----------------------------------U T I L I T Y -- M E T H O D S ----------------------------------------------->


    public ResultSet searchClient(String pAddress) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Clients WHERE PayeeAddress = '"+pAddress+"';");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return resultSet;
    }

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


        public ResultSet getCheckingAccountData(String pAddress) {
            Statement statement;
            ResultSet resultSet = null;
            try {
                statement = this.conn.createStatement();
                resultSet = statement.executeQuery("SELECT * FROM CheckingAccounts WHERE Owner='"+pAddress+"';");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
            return resultSet;
        }

    public ResultSet getSavingsAccountData(String pAddress) {
        Statement statement;
        ResultSet resultSet = null;
        try {
            statement = this.conn.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM SavingsAccounts WHERE Owner='"+pAddress+"';");
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return resultSet;
    }

}








