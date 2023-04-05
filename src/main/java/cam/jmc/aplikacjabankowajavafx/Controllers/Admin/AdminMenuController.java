package cam.jmc.aplikacjabankowajavafx.Controllers.Admin;

import cam.jmc.aplikacjabankowajavafx.Models.Model;
import cam.jmc.aplikacjabankowajavafx.Views.AdminMenuOptions;
import cam.jmc.aplikacjabankowajavafx.Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
        create_clients_button.setOnAction(event -> onCreateClient());
        clients_button.setOnAction(event -> onClients());
        deposit_button.setOnAction(event-> onDeposit());
        logout_button.setOnAction(event-> onLogout());
    }

    private void onCreateClient() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CREATE_CLIENT);
    }

    private void onClients() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.CLIENTS);
    }

    private void onDeposit() {
        Model.getInstance().getViewFactory().getAdminSelectedMenuItem().set(AdminMenuOptions.DEPOSIT);
    }

    private void onLogout() {
        //Get Stage
        Stage stage =(Stage) clients_button.getScene().getWindow();
        //Close the admin Window
        Model.getInstance().getViewFactory().closeStage(stage);
        //show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        //set admin loginSuccessFlag to false
        Model.getInstance().setAdminLoginSuccessFlag(false);

    }
}
