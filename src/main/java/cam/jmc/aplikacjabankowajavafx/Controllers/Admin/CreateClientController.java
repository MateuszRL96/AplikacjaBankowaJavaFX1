package cam.jmc.aplikacjabankowajavafx.Controllers.Admin;

import cam.jmc.aplikacjabankowajavafx.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.util.Random;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {
    public TextField firstname_field;//
    public TextField lastname_field;//
    public TextField password_field;//
    public Label pAddress_label;//
    public CheckBox ch_account_box;//
    public TextField saving_account_balance_field;//
    public Button create_client_button;//
    public Label error_label;//
    public CheckBox sc_account_box;//
    public TextField checking_account_balance_field;
    public CheckBox pAdress_box;//


    private String payeeAddress;
    private boolean createCheckingAccountFlag = false;
    private boolean createSavingsAccountFlag = false;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {
        create_client_button.setOnAction(event->createClient());
        pAdress_box.selectedProperty().addListener((observableValue, oldValue, newValue) ->
        {
            if(newValue) {
                payeeAddress = createPayeeAddress();
                onCreatePayeeAddress();
            }
        });
        ch_account_box.selectedProperty().addListener((observableValue, oldValue, newValue) ->
        {
            if(newValue) {
                createCheckingAccountFlag = true;
            }
        });
        sc_account_box.selectedProperty().addListener((observableValue, oldValue, newValue) ->
        {
            if(newValue) {
                createSavingsAccountFlag = true;
            }
        });
    }

    private void createClient() {
        //create checking account
        if(createCheckingAccountFlag){
            createAccount("Checking");
        }
        //Create Savings Account
        if(createSavingsAccountFlag){
            createAccount("Savings");
        }
        //Create Client
        String firstName = firstname_field.getText();
        String lastName = lastname_field.getText();
        String password = password_field.getText();
        Model.getInstance().getDatabaseDriver().createClient(firstName, lastName, payeeAddress, password, LocalDate.now());
        error_label.setStyle("-fx-text-fill: blue; -fx-font-size: 1.3em; -fx-font-weight: bold;");
        error_label.setText("Client Created Successfully!!!");
        emptyFields();
    }

    private void createAccount(String accountType) {
        double balance = Double.parseDouble(checking_account_balance_field.getText());
        //Generate Account Number
        String firstSection = "3210";
        String lastSection = Integer.toString((new Random()).nextInt(9999) + 1000);
        String accountNumber = firstSection + " " + lastSection;
        // create yhe checking or savings account

        if(accountType.equals("Checking")) {
            Model.getInstance().getDatabaseDriver().createCheckingAccount(payeeAddress, accountNumber, 10, balance);
        }
        else{
            Model.getInstance().getDatabaseDriver().createSavingsAccount(payeeAddress, accountNumber, 2000, balance);
        }
    }

    private void onCreatePayeeAddress() {
        if(firstname_field.getText() != null && lastname_field.getText() != null) {
            pAddress_label.setText(payeeAddress);
        }
    }

    private String createPayeeAddress(){
        int id = Model.getInstance().getDatabaseDriver().getLastClientId();
        char fChar = Character.toLowerCase(firstname_field.getText().charAt(0));
        return "@"+fChar+lastname_field.getText()+id;
    }

    private void emptyFields() {
        firstname_field.setText("");
        lastname_field.setText("");
        password_field.setText("");
        pAdress_box.setSelected(false);
        pAddress_label.setText("");
        ch_account_box.setSelected(false);
        checking_account_balance_field.setText("");
        sc_account_box.setSelected(false);
        saving_account_balance_field.setText("");
    }




}
