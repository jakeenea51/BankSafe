public class Checking_F2022_BankSafe extends Account_F2022_BankSafe{
    

    //constructors
    /** This is the default constructor for creating a new Checking object. Account number and routing number will be automatically generated. */
    public Checking_F2022_BankSafe(){
        setAccountNum(generateNum());
        setRoutingNum(generateNum());
    }

    /**
     * This constructor will create a new Checking object with an initial deposit. Account number and routing number will be automatically generated.
     * @param balance The balance in the account
     */
    public Checking_F2022_BankSafe(double balance){
        setAccountNum(generateNum());
        setRoutingNum(generateNum());
        deposit(balance);
    }

    /**
     * This constructor will create a new Checking object using information imported from the accounts.txt file.
     * @param balance The balance in the account
     * @param accountNum The account's identification number
     * @param routingNum The account's routing number
     * @param frozen Frozen status of the account
     */
    public Checking_F2022_BankSafe(double balance, int accountNum, int routingNum, boolean frozen){
        setBalance(balance);
        setAccountNum(accountNum);
        setRoutingNum(routingNum);
        setFrozen(frozen);
    }

}