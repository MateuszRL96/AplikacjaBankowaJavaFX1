package cam.jmc.aplikacjabankowajavafx.Controllers.Client;

import cam.jmc.aplikacjabankowajavafx.Models.Model;
import cam.jmc.aplikacjabankowajavafx.Views.ClientMenuOptions;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable {
    public Button dashboard_btn;
   public Button transaction_btn;
    public Button accounts_btn;
    public Button profile_btn;
    public Button logout_btn;
    public Button report_btn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        addListener();
    }

    private void addListener()
    {
        dashboard_btn.setOnAction(event -> onDashboard());
        transaction_btn.setOnAction(event-> onTransactions());
        accounts_btn.setOnAction(event-> onAccounts());
        logout_btn.setOnAction(event-> onLogout());
    }

    private void onDashboard() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.DASHBOARD);
    }

    private void onTransactions() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.TRANSACTIONS);
    }

    private void onAccounts() {
        Model.getInstance().getViewFactory().getClientSelectedMenuItem().set(ClientMenuOptions.ACCOUNTS);
    }

    private void onLogout() {
        //Get Stage
        Stage stage =(Stage) dashboard_btn.getScene().getWindow();
        //Close the client Window
        Model.getInstance().getViewFactory().closeStage(stage);
        //show Login Window
        Model.getInstance().getViewFactory().showLoginWindow();
        //set client loginSuccessFlag to false
        Model.getInstance().setClientLoginSuccessFlag(false);

    }

}
