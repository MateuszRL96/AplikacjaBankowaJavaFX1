package cam.jmc.aplikacjabankowajavafx.Controllers.Client;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountsController implements Initializable {
    public Label checking_account_number;
    public Label transaction_limit;
    public Label checking_account_date;
    public Label checking_account_balance;
    public Label saving_account_number;
    public Label withdraw_limit;
    public Label saving_account_date;
    public Label saving_balance;
    public TextField amount_to_savings;
    public Button trans_to_saving_button;
    public TextField amount_to_checking;
    public Button transfer_to_checking_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
