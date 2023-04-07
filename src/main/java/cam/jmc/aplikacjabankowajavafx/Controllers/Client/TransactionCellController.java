package cam.jmc.aplikacjabankowajavafx.Controllers.Client;

import cam.jmc.aplikacjabankowajavafx.Models.Transaction;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class TransactionCellController implements Initializable {

    public FontAwesomeIconView in_icon;
    public FontAwesomeIconView out_icon;
    public Label transaction_date_label;
    public Label sender_label;
    public Label receiver_label;
    public Label amount_label;

    private final Transaction transaction;

    public TransactionCellController(Transaction transaction){
        this.transaction = transaction;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sender_label.textProperty().bind(transaction.senderProperty());
        receiver_label.textProperty().bind(transaction.receiverProperty());
        amount_label.textProperty().bind(transaction.amountProperty().asString());
        transaction_date_label.textProperty().bind(transaction.dateProperty().asString());
    }
}
