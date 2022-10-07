public class Checking_F2022_BankSafe extends Account_F2022_BankSafe{
    

    //constructors
    //for creating a new checking account
    public Checking_F2022_BankSafe(){
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
    }

    //for importing existing accounts from csv
    /**
     * @param balance The balance in the account
     * @param accountingNum The account's identification number
     * @param routingNum The account's routing number
     * @param frozen Whether the account is frozen
     */
    public Checking_F2022_BankSafe(double balance, int accountNum, int routingNum, boolean frozen){
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
    public Checking_F2022_BankSafe(double balance){
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
        deposit(balance);
    }

}