package cam.jmc.aplikacjabankowajavafx.Models;

import cam.jmc.aplikacjabankowajavafx.Views.ViewFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.time.LocalDate;
public class Model
{
    private static Model model;
    private final ViewFactory viewFactory;
    private final DatabaseDriver databaseDriver;



    //--------------------------------- C L I E N T -- D A T A -- S E C T I O N---------------------------------------->


    private Client client;
    private boolean clientLoginSuccessFlag;



    //---------------------------------- A D M I N ---- D A T A -- S E C T I O N -------------------------------------->



    private boolean adminLoginSuccessFlag;
    private final ObservableList<Client> clients;

    private Model()
    {
        this.viewFactory = new ViewFactory();
        this.databaseDriver = new DatabaseDriver();
        //Client Data Section
        this.clientLoginSuccessFlag = false;
        this.client = new Client("", "", "", null, null, null);
        //Admin Data Section
        this.adminLoginSuccessFlag = false;
        this.clients = FXCollections.observableArrayList();

    }
    public static synchronized Model getInstance()
    {
        if(model == null)
        {
            model = new Model();
        }
        return model;
    }
    public ViewFactory getViewFactory()
    {
        return viewFactory;
    }
    public DatabaseDriver getDatabaseDriver()
    {
        return databaseDriver;
    }





    //------------------------------------C L I E N T -- M E T H O D -- S E C T I O N --------------------------------->





    public boolean getClientLoginSuccessFlag()
    {
        return this.clientLoginSuccessFlag;
    }

    public void setClientLoginSuccessFlag(boolean flag)
    {
        this.clientLoginSuccessFlag = flag;
    }

    public Client getClient()
    {
        return client;
    }
    public void evaluateClientCred(String pAddress, String password)
    {
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getClientData(pAddress, password);
        try
        {
            if (resultSet.isBeforeFirst())
            {
                while (resultSet.next())
                {
                    this.client.firstNameProperty().set(resultSet.getString("FirstName"));
                    this.client.lastNameProperty().set(resultSet.getString("LastName"));
                    this.client.payeeAddressProperty().set(resultSet.getString("PayeeAddress"));
                    String[] dateParts = resultSet.getString("Date").split("-");
                    LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                    this.client.dateProperty().set(date);
                    checkingAccount = getCheckingAccount(pAddress);
                    savingsAccount = getSavingsAccount(pAddress);
                    this.client.checkingAccountProperty().set(checkingAccount);
                    this.client.savingsAccountProperty().set(savingsAccount);
                    this.clientLoginSuccessFlag = true;
                }
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    //--------------------------------- A D M I N -- M E T H O D -- S E C T I O N ------------------------------------->


    public boolean getAdminLoginSuccessFlag()
    {
        return this.adminLoginSuccessFlag;
    }
    public void setAdminLoginSuccessFlag(boolean adminLoginSuccessFlag)
    {
        this.adminLoginSuccessFlag = adminLoginSuccessFlag;
    }

    public void evaluateAdminCred(String username, String password)
    {
        ResultSet resultSet = databaseDriver.getAdminData(username, password);
        try
        {
            if(resultSet.isBeforeFirst())
            {
                this.adminLoginSuccessFlag = true;
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


    public ObservableList<Client> getClients() {
        return clients;
    }

    public void setClients() {
        CheckingAccount checkingAccount;
        SavingsAccount savingsAccount;
        ResultSet resultSet = databaseDriver.getAllClientsData();
        try {
            while (resultSet.next()){
                String firstName = resultSet.getString("FirstName");
                String lastName =resultSet.getString("LastName");
                String pAddress =resultSet.getString("PayeeAddress");
                String[] dateParts = resultSet.getString("Date").split("-");
                LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
                checkingAccount = getCheckingAccount(pAddress);
                savingsAccount = getSavingsAccount(pAddress);
                clients.add(new Client(firstName, lastName, pAddress, checkingAccount, savingsAccount, date));
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public ObservableList<Client> searchClient(String pAddress){
        ObservableList<Client> searchResults = FXCollections.observableArrayList();
        ResultSet resultSet = databaseDriver.searchClient(pAddress);
        try{
            CheckingAccount checkingAccount = getCheckingAccount(pAddress);
            SavingsAccount savingsAccount = getSavingsAccount(pAddress);
            String firstName = resultSet.getString("FirstName");
            String lastName =resultSet.getString("LastName");
            String[] dateParts = resultSet.getString("Date").split("-");
            LocalDate date = LocalDate.of(Integer.parseInt(dateParts[0]), Integer.parseInt(dateParts[1]), Integer.parseInt(dateParts[2]));
            searchResults.add(new Client(firstName, lastName, pAddress, checkingAccount, savingsAccount, date));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return searchResults;
    }

    //------------------------------- U T I L I T Y -- M E T H O D S -- S E C T I O N --------------------------------->

    public CheckingAccount getCheckingAccount(String pAddress){
        CheckingAccount account = null;
        ResultSet resultSet = databaseDriver.getCheckingAccountData(pAddress);
        try {
            String num = resultSet.getString("AccountNumber");
            int tLimit = (int) resultSet.getDouble("TransactionLimit");
            double balance = resultSet.getDouble("Balance");
            account = new CheckingAccount(pAddress, num, balance, tLimit);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return account;
    }

    public SavingsAccount getSavingsAccount(String pAddress){
        SavingsAccount account = null;
        ResultSet resultSet = databaseDriver.getSavingsAccountData(pAddress);
        try {
            String num = resultSet.getString("AccountNumber");
            double wLimit = resultSet.getDouble("WithdrawalLimit");
            double balance = resultSet.getDouble("Balance");
            account = new SavingsAccount(pAddress, num, balance, wLimit);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return account;
    }
}
