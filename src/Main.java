import java.util.Date;

public class Main {
    public static void main(String[] args) {
        var account = new BankAccount("Kendra", 10000);
        System.out.printf("Account %s was created for %s with %s.",
                account.Number,
                account.Owner,
                account.Balance());

        account.MakeWithdrawal(120, new Date(), "Hammock");
        System.out.println(account.Balance());

        account.MakeWithdrawal(50, new Date(), "XBOX Game");
        System.out.println(account.Balance());

        System.out.println(account.GetAccountHistory());

        // test for a negative balance:
        try {
            account.MakeWithdrawal(75000, new Date(), "Attempt to overdraw");
        } catch (Exception e) {
            throw new RuntimeException("Exception caught trying to overdraw", e);
        }

        // test that initial balance must be positive.
        try {
            var invalidAccount = new BankAccount("invalid", -55);
        } catch (Exception e) {
            throw new RuntimeException("Exception caught creating account with negative balance", e);
        }
    }
}