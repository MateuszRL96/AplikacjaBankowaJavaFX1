package cam.jmc.aplikacjabankowajavafx.Controllers.Client;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
