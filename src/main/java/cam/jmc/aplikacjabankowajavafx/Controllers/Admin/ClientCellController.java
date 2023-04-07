package cam.jmc.aplikacjabankowajavafx.Controllers.Admin;

import cam.jmc.aplikacjabankowajavafx.Models.Client;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientCellController implements Initializable {

    public Label FirstName_label;
    public Label LastName_label;
    public Label pAddress_label;
    public Label checking_account_label;
    public Label saving_account_label;
    public Label date_label;
    public Button delete_button;

    private final Client client;

    public ClientCellController(Client client){
        this.client = client;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FirstName_label.textProperty().bind(client.firstNameProperty());
        LastName_label.textProperty().bind(client.lastNameProperty());
        pAddress_label.textProperty().bind(client.payeeAddressProperty());
        checking_account_label.textProperty().bind(client.checkingAccountProperty().asString());
        saving_account_label.textProperty().bind(client.savingsAccountProperty().asString());
        date_label.textProperty().bind(client.dateProperty().asString());
    }
}
