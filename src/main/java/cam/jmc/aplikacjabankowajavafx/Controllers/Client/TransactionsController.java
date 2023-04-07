package cam.jmc.aplikacjabankowajavafx.Controllers.Client;

import cam.jmc.aplikacjabankowajavafx.Models.Model;
import cam.jmc.aplikacjabankowajavafx.Models.Transaction;
import cam.jmc.aplikacjabankowajavafx.Views.TransactionCellFactory;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionsController implements Initializable {
    public ListView<Transaction> transactions_listview;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initAllTransactionsList();
        transactions_listview.setItems(Model.getInstance().getAllTransactions());
        transactions_listview.setCellFactory(e -> new TransactionCellFactory());
    }

    private void initAllTransactionsList() {
        if (Model.getInstance().getAllTransactions().isEmpty()){
            Model.getInstance().setAllTransactions();
        }
    }

}