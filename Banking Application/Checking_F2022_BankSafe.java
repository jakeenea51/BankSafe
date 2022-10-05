public class Checking_F2022_BankSafe extends Account_F2022_BankSafe{
    

    //constructors
    //default
    public Checking_F2022_BankSafe(){
    }

    //for creating a new checking account
    /**
     * @param fName The first name of the owner
     * @param lName The last name of the owner
     */
    public Checking_F2022_BankSafe(String fName, String lName){
        setFName(fName);
        setLName(lName);
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
    }

    //for importing existing accounts from csv
    /**
     * @param fName The first name of the owner
     * @param lName The last name of the owner
     * @param balance The balance in the account
     * @param accountingNum The account's identification number
     * @param routingNum The account's routing number
     */
    public Checking_F2022_BankSafe(String fName, String lName, double balance, int accountNum, int routingNum, boolean frozen){
        setFName(fName);
        setLName(lName);
        setBalance(balance);
        setAccountNum(accountNum);
        setRoutingNum(routingNum);
        setFrozen(frozen);
    }

    //with info and initial deposit
    /**
     * @param fName The first name of the owner
     * @param lName The last name of the owner
     * @param balance Balance in the account
     */
    public Checking_F2022_BankSafe(String fName, String lName, double balance){
        setFName(fName);
        setLName(lName);
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
        deposit(balance);
    }

}