package cam.jmc.aplikacjabankowajavafx.Controllers.Admin;

import cam.jmc.aplikacjabankowajavafx.Models.Model;
import cam.jmc.aplikacjabankowajavafx.Views.AdminMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class AdminMenuController implements Initializable {
    public Button create_clients_button;
    public Button clients_button;
    public Button deposit_button;
    public Button logout_button;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListeners();
    }

    private void addListeners() {

    }

    private void onCreateClient() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }
}
