// import java.util.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class BankAccount {
    public String Number;
    public String Owner;
    private static int accountNumberSeed = 1234567890;
    private List<Transaction> allTransactions = new ArrayList<Transaction>();

    public double Balance() {
        double balance = 0;
        for (var item : allTransactions) {
            balance += item.Amount;
        }
        return balance;
    }

    public BankAccount(String name, double initialBalance) {
        this.Owner = name;
        MakeDeposit(initialBalance, new Date(), "Initial Balance");
        this.Number = String.valueOf(accountNumberSeed);
        accountNumberSeed++;
    }

    public void MakeDeposit(double amount, Date dateTime, String note) {
        if (amount <= 0) {
            throw new RuntimeException("Amount of deposit must be positive");
        }
        var deposit = new Transaction(amount, dateTime, note);
        allTransactions.add(deposit);
    }

    public void MakeWithdrawal(double amount, Date dateTime, String note) {
        if (amount <= 0) {
            throw new RuntimeException("Amount of withdrawal must be positive");
        }
        if (Balance() - amount < 0) {
            throw new RuntimeException("Not sufficient funds for this withdrawal");
        }
        var withdrawal = new Transaction(-amount, dateTime, note);
        allTransactions.add(withdrawal);
    }

    public String GetAccountHistory() {
        var report = new StringBuilder();
        //HEADER
        report.append("Date\t\tAmount\tNote\n");
        for (var item : allTransactions) {
            //ROWS
            Formatter fmt = new Formatter();
            fmt.format("%s\t%s\t%s\n", item.DateTime, item.Amount, item.Notes);
            report.append(fmt);
        }
        return report.toString();
    }
}
