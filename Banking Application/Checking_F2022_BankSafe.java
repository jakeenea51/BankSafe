public class Checking_F2022_BankSafe extends Account_F2022_BankSafe{
    

    //constructors
    //default
    public Checking_F2022_BankSafe(){
    }

    //with info
    public Checking_F2022_BankSafe(String fName, String lName){
        setFName(fName);
        setLName(lName);
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
    }

    //with info and initial deposit
    public Checking_F2022_BankSafe(String fName, String lName, double balance){
        setFName(fName);
        setLName(lName);
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
        deposit(balance);
    }

}