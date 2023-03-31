package cam.jmc.aplikacjabankowajavafx.Views;

import cam.jmc.aplikacjabankowajavafx.Controllers.Client.TransactionCellController;
import cam.jmc.aplikacjabankowajavafx.Models.Transaction;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListCell;

public class TransactionCellFactory extends ListCell<Transaction> {
    @Override
    protected void updateItem(Transaction transaction, boolean empty) {
        super.updateItem(transaction, empty);
        if(empty) {
            setText(null);
            setGraphic(null);
        }
        else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Fxml/Client/TransactionCall.fxml"));
            TransactionCellController controller = new TransactionCellController(transaction);
            loader.setController(controller);
            setText(null);
            try {
                setGraphic(loader.load());
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
}
