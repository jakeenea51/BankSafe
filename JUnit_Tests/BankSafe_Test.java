import org.junit.Test;
import static org.junit.Assert.*;

public class BankSafe_Test {
    
    @Test
    public void createCheckingAccountTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe("John", "Doe", 2000);
        assertEquals("John", account1.getFName());
        assertEquals("Doe", account1.getLName());
        assertEquals(2000, account1.getBalance(), .01);
    }

    
    @Test
    public void depositTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe("John", "Doe", 2000);
        account1.deposit(300);
        assertEquals(2300, account1.getBalance(), .01);
    }


    @Test
    public void withdrawTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe("John", "Doe", 2000);
        account1.withdraw(500);
        assertEquals(1500, account1.getBalance(), .01);
    }


    @Test
    public void interestPaymentTest(){
        Savings_F2022_BankSafe account1 = new Savings_F2022_BankSafe("John", "Doe", 2000);
        account1.setInterestRate(.035);
        account1.interestPayment();
        assertEquals(2070, account1.getBalance(), .01);
    }


    @Test
    public void overdraftTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe("John", "Doe", 2000);
        account1.withdraw(2300);
        account1.overdraft();
        assertEquals(-325, account1.getBalance(), .01);
    }

}
