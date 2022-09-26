public class Checking_F2022_BankSafe extends Account_F2022_BankSafe{
    

    //constructors
    //default
    public Checking_F2022_BankSafe(){
    }

    //with info
    public Checking_F2022_BankSafe(String fName, String lName, String accountNum){
        setFName(fName);
        setLName(lName);
        setAccountNum(accountNum);
    }

    //with info and initial deposit
    public Checking_F2022_BankSafe(String fName, String lName, String accountNum, double balance){
        setFName(fName);
        setLName(lName);
        setAccountNum(accountNum);
        deposit(balance);
    }

}