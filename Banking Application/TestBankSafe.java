public class TestBankSafe {
    public static void main(String[] args) {

        Savings_F2022_BankSafe account1 = new Savings_F2022_BankSafe("Jake", "Enea", "000001");
        account1.deposit(200.00);

        System.out.println("Account Number: " + account1.getAccountNum());
        System.out.println("This account belongs to " + account1.getFName() + " " + account1.getLName());
        System.out.println("Amount in account: " + account1.getAmount());

    }
}
