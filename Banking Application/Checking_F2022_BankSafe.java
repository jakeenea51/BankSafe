public class Checking_F2022_BankSafe extends Account_F2022_BankSafe{
    

    //constructors
    //default
    public Checking_F2022_BankSafe(){
    }

    //with info
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