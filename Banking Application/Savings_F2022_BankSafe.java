public class Savings_F2022_BankSafe extends Account_F2022_BankSafe{
    
    /** Interest rate of the Savings account */
    public double interestRate = 0;

    //constructors
    /** This is the default constructor for creating a new Savings object. Account number and routing number will be automatically generated. */
    public Savings_F2022_BankSafe(){
        setAccountNum(generateNum());
        setRoutingNum(generateNum());
    }

    /**
     * This constructor will create a new Savings object with an initial deposit. Account number and routing number will be automatically generated.
     * @param balance The balance in the account
     */
    public Savings_F2022_BankSafe(double balance){
        setAccountNum(generateNum());
        setRoutingNum(generateNum());
        try{
        deposit(balance);
        }
        catch(InvalidAmountException ex){
            System.out.println(ex);
        }
    }

    /**
     * This constructor will create a new Savings object using information imported from the accounts.txt file.
     * @param balance The balance in the account
     * @param accountNum The account's identification number
     * @param routingNum The account's routing number
     * @param frozen Frozen status of the account
     */
    public Savings_F2022_BankSafe(double balance, int accountNum, int routingNum, boolean frozen){
        setBalance(balance);
        setAccountNum(accountNum);
        setRoutingNum(routingNum);
        setFrozen(frozen);
    }


    /**
     * Method to set the account's interest rate.
     * @param interestRate The interest rate for the account
     */
    public void setInterestRate(double interestRate){
        this.interestRate = interestRate;
    }

    
    /** Method to initiate an interest payment on the account. */
    public void interestPayment(){
        this.balance += (interestRate * this.balance);
    }


}
