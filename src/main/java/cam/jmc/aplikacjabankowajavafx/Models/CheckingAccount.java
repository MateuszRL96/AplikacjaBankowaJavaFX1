package cam.jmc.aplikacjabankowajavafx.Models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;



public class CheckingAccount extends Account{
    //The Number of transactions a client is allowed to do per day;
    private final IntegerProperty transactionLimit;

    public CheckingAccount(String owner, String accountNumber, double balance, int limit)
    {
        super(owner, accountNumber, balance);
        this.transactionLimit = new SimpleIntegerProperty(this, "Transaction Limit", limit);
    }

    public IntegerProperty transactionLimitProperty() {
        return transactionLimit;
    }

    @Override
    public String toString() {
        return accountNumberProperty().get();
    }

}
