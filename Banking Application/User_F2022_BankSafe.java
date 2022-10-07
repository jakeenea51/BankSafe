import java.util.*;

public class User_F2022_BankSafe {
    
    private String username, password, fName, lName;
    public ArrayList<Account_F2022_BankSafe> userAccounts = new ArrayList<Account_F2022_BankSafe>();

    //default constructor
    public User_F2022_BankSafe(){
    }

    //constructor for new account
    public User_F2022_BankSafe(String username, String password, String fName, String lName){
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
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

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }


    //add account to userAccounts ArrayList
    public void addAccount(Account_F2022_BankSafe account){
        userAccounts.add(account);
    }

}

