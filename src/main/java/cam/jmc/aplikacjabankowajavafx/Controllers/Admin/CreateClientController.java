package cam.jmc.aplikacjabankowajavafx.Controllers.Admin;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CreateClientController implements Initializable {
    public TextField firstname_field;
    public TextField lastname_field;
    public TextField password_field;
    public Label pAddress_label;
    public CheckBox ch_account_box;
    public TextField saving_account_balance_field;
    public Button create_client_button;
    public Label error_label;
    public CheckBox sc_account_box;
    public TextField checking_account_balance_field;
    public CheckBox pAdress_box;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
