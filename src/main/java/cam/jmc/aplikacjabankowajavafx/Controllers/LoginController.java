package cam.jmc.aplikacjabankowajavafx.Controllers;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    public TextField payee_address_fld;
    public TextField password_fld;
    public Button login_btn;
    public Label payee_address_lbl;
    public ChoiceBox acc_selector;
    public Label error_lbl;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //login_btn.setOnAction(event-> );
    }
}
