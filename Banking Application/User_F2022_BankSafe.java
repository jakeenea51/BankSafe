import java.util.*;

public class User_F2022_BankSafe {
    
    private String username, password, fName, lName;
    public ArrayList<Account_F2022_BankSafe> userAccounts = new ArrayList<Account_F2022_BankSafe>();

    /**
     * This is the default constructor for creating a new User object. 
     */
    public User_F2022_BankSafe(){
    }

    //constructor for new account
    /**
     * This constructor will create a new User object with all required user information.
     * @param username Username of the user profile
     * @param password Password for the user profile
     * @param fName First name of the owner of the user profile
     * @param lName Last name of the owner of the user profile
     */
    public User_F2022_BankSafe(String username, String password, String fName, String lName){
        this.username = username;
        this.password = password;
        this.fName = fName;
        this.lName = lName;
    }

    //get and set methods
    /**
     * Method to get the owner's first name.
     * @return First name of the owner of the user profile
     */
    public String getFName(){
        return fName;
    }
    
    /**
     * Method to set the owner's first name.
     * @param fName First name of the owner of the user profile
     */
    public void setFName(String fName){
        this.fName = fName;
    }
    
    /**
     * Method to get the owner's last name.
     * @return Last name of the owner of the user profile
     */
    public String getLName(){
        return lName;
    }
    
    /**
     * Method to set the owner's last name.
     * @param lName Last name of the owner of the user profile
     */
    public void setLName(String lName){
        this.lName = lName;
    }

    /**
     * Method to get the username of the user profile.
     * @return Username of the user profile
     */
    public String getUsername(){
        return username;
    }

    /**
     * Method to get the password for the user profile.
     * @return Password for the user profile
     */
    public String getPassword(){
        return password;
    }


    //add account to userAccounts ArrayList
    /**
     * Method to add account to ArrayList containing all accounts under this user profile. 
     * @param account Account to be added to user profile
     */
    public void addAccount(Account_F2022_BankSafe account){
        userAccounts.add(account);
    }

}

