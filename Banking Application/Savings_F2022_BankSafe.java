public class Savings_F2022_BankSafe extends Account_F2022_BankSafe{
    
    public double interestRate = 0;

    //constructors
    //default constructor
    public Savings_F2022_BankSafe(){
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
    }

    //with initial deposit
    /**
     * @param balance Balance in the account
     */
    public Savings_F2022_BankSafe(double balance){
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
        deposit(balance);
    }

    //for importing existing accounts from csv
    /**
     * @param fName The first name of the owner
     * @param lName The last name of the owner
     * @param balance The balance in the account
     * @param accountingNum The account's identification number
     * @param routingNum The account's routing number
     */
    public Savings_F2022_BankSafe(double balance, int accountNum, int routingNum, boolean frozen){
        setBalance(balance);
        setAccountNum(accountNum);
        setRoutingNum(routingNum);
        setFrozen(frozen);
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
