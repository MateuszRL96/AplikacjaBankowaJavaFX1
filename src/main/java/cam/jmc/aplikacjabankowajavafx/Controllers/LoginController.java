package cam.jmc.aplikacjabankowajavafx.Controllers;

import cam.jmc.aplikacjabankowajavafx.Models.Model;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
        login_btn.setOnAction(event-> onLogin());
    }

    private void onLogin()
    {
        Stage stage = (Stage) error_lbl.getScene().getWindow();
        Model.getInstance().getViewFactory().closeStage(stage);
        Model.getInstance().getViewFactory().showClientWindow();
    }
}
