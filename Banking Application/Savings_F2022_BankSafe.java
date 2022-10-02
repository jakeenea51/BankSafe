public class Savings_F2022_BankSafe extends Account_F2022_BankSafe{
    
    public double interestRate = 0;

    //constructors
    //default
    public Savings_F2022_BankSafe(){
    }

    //with info
    public Savings_F2022_BankSafe(String fName, String lName){
        setFName(fName);
        setLName(lName);
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
    }

    //with info and initial deposit
    public Savings_F2022_BankSafe(String fName, String lName, double balance){
        setFName(fName);
        setLName(lName);
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
        deposit(balance);
    }


    //set interest rate
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    
    //method for interest payments
    public void interestPayment(){
        this.balance += (interestRate * this.balance);
    }


}
