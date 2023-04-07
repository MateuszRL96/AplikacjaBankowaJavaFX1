package cam.jmc.aplikacjabankowajavafx.Controllers.Admin;

import cam.jmc.aplikacjabankowajavafx.Models.Client;
import cam.jmc.aplikacjabankowajavafx.Models.Model;
import cam.jmc.aplikacjabankowajavafx.Views.ClientCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class ClientsController implements Initializable {
    public ListView<Client> clients_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        iniData();
        clients_listview.setItems(Model.getInstance().getClients());
        clients_listview.setCellFactory(e-> new ClientCellFactory());
    }

    private void iniData() {
        if(Model.getInstance().getClients().isEmpty()){
            Model.getInstance().setClients();
        }
    }
}
