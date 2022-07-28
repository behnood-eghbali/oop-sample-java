import java.util.Date;

public class Transaction {
    public double Amount;
    public Date DateTime;
    public String Notes;

    public Transaction(double amount, Date dateTime, String note) {
        this.Amount = amount;
        this.DateTime = dateTime;
        this.Notes = note;
    }
}
