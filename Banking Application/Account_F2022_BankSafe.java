public abstract class Account_F2022_BankSafe{

    public String fName, lName, accountNum;
    public double amount = 0;


    //constructors
    //default
    public Account_F2022_BankSafe(){
    }

    //with name
    public Account_F2022_BankSafe(String fName, String lName, String accountNum){
        this.fName = fName;
        this.lName = lName;
        this.accountNum = accountNum;
    }


    //get and set methods
    public String getFName(){
        return fName;
    }

    public void setFName(String fName){
        this.fName = fName;
    }

    public String getLName(){
        return lName;
    }

    public void setLName(String lName){
        this.lName = lName;
    }

    public String getAccountNum(){
        return accountNum;
    }

    public void setAccountNum(String accountNum){
        this.accountNum = accountNum;
    }

    public double getAmount(){
        return amount;
    }


    //deposit and withdraw methods
    public void deposit(double deposit){
        this.amount += deposit;
    }

    public void withdraw(double withdraw){
        this.amount -= withdraw;
    }

}