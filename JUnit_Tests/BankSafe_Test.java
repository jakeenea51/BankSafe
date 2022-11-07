import org.junit.Test;
import static org.junit.Assert.*;

public class BankSafe_Test {
    
    @Test
    public void createCheckingAccountTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe(2000);
        assertEquals(2000, account1.getBalance(), .01);
    }

    
    @Test
    public void depositTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe(2000);
        try{
            account1.deposit(300);
        }
        catch(InvalidAmountException ex){
            System.out.println(ex);
        }
        assertEquals(2300, account1.getBalance(), .01);
    }


    @Test
    public void withdrawTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe(2000);
        try{
            account1.withdraw(500);
        }
        catch(InvalidAmountException ex){
            System.out.println(ex);
        }
        assertEquals(1500, account1.getBalance(), .01);
    }


    @Test
    public void interestPaymentTest(){
        Savings_F2022_BankSafe account1 = new Savings_F2022_BankSafe(2000);
        account1.setInterestRate(.035);
        account1.interestPayment();
        assertEquals(2070, account1.getBalance(), .01);
    }


    @Test
    public void overdraftTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe(2000);
        try{
            account1.withdraw(2300);
        }
        catch(InvalidAmountException ex){
            System.out.println(ex);
        }
        account1.overdraft();
        assertEquals(-325, account1.getBalance(), .01);
    }


    @Test
    public void validateNumTest(){
        assertEquals(true, Account_F2022_BankSafe.validateNum(234567890));
        assertEquals(false, Account_F2022_BankSafe.validateNum(1234567890));
    }


    @Test
    public void invalidAmountExceptionTest(){
        Checking_F2022_BankSafe account1 = new Checking_F2022_BankSafe(2000);
        try{
            account1.withdraw(-50);
        }
        catch(InvalidAmountException ex){
            System.out.println(ex);
        }
        assertEquals(2000, account1.getBalance(), .01);
    }

}
