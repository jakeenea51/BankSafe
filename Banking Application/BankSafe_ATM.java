import java.util.*;

public class BankSafe_ATM {
    public static void main(String[] args) {

        Savings_F2022_BankSafe account1 = new Savings_F2022_BankSafe("Jake", "Enea", "000001", 3000);
        account1.deposit(200.00);

        System.out.println("Account Number: " + account1.getAccountNum());
        System.out.println("This account belongs to " + account1.getFName() + " " + account1.getLName());
        System.out.println("Account balance: " + account1.getBalance());
        
    }
}
