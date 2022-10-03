public class Savings_F2022_BankSafe extends Account_F2022_BankSafe{
    
    public double interestRate = 0;

    //constructors
    //default
    public Savings_F2022_BankSafe(){
    }

    /**
     * Construtor method with name
     * @param fName The first name of the owner
     * @param lName The last name of the owner
     */
    public Savings_F2022_BankSafe(String fName, String lName){
        setFName(fName);
        setLName(lName);
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
    }

    //with info and initial deposit
    /**
     * @param fName The first name of the owner
     * @param lName The last name of the owner
     * @param balance Balance in the account
     */
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
