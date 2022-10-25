import java.util.*;

public abstract class Account_F2022_BankSafe extends User_F2022_BankSafe{

    //fields
    /**
     * Random object used for generating the account and routing numbers
     */
    private static Random random = new Random();
    /**
     * Account number of the account
     */
    private int accountNum;
    /**
     * Routing number of the account
     */
    private int routingNum;
    /**
     * Balance of the account
     */
    public double balance = 0;
    /**
     * Frozen status of the account
     */
    private boolean frozen = false;

    /**
     * ArrayList containing all account and routing numbers to ensure that each randomly generated account and routing number is unique
     */
    private static ArrayList<Integer> nums = new ArrayList<Integer>();

    Scanner input = new Scanner(System.in);


    //constructors
    /**
     * This is the default constructor for creating a new Account object.
     */
    public Account_F2022_BankSafe(){
    }


    //get and set methods
    /**
     * Method to get account number.
     * @return Account number of the account
     */
    public int getAccountNum(){
        return accountNum;
    }

    /**
     * Method to set account number.
     * @param accountNum The account number of the account
     */
    public void setAccountNum(int accountNum){
        if (validateNum(accountNum))
            this.accountNum = accountNum;
        else
            System.out.println("invalid");
    }
    
    /**
     * Method to get routing number.
     * @return Routing number of the account
     */
    public int getRoutingNum(){
        return routingNum;
    }

    /**
     * Method to set routing number.
     * @param routingNum The routing number of the account
     */
    public void setRoutingNum(int routingNum){
        if (validateNum(routingNum))
            this.routingNum = routingNum;
        else
            System.out.println("invalid");
    }

    /**
     * Method to get account balance.
     * @return The balance in the account
     */
    public double getBalance(){
        return balance;
    }

    /**
     * Method to set account balance.
     * @param balance The balance in the account
     */
    public void setBalance(double balance){
        this.balance = balance;
    }

    /**
     * Method to get frozen status.
     * @return Frozen status of the account
     */
    public boolean isFrozen(){
        return frozen;
    }

    /**
     * Method to set frozen status.
     * @param frozen Frozen status of the account
     */
    public void setFrozen(boolean frozen){
        this.frozen = frozen;
    }


    //method to generate an account number
    /**
     * Method to generate a random account or routing number.
     * @return Random, unique, 9-digit number to be used for either the account number or the routing number
     */
    public static int generateNum(){
        int num = 100000000 + random.nextInt(900000000);
        if (nums.contains(num))
            num = generateNum();
        else if (!validateNum(num))
            num = generateNum();
        return num;
    }


    /**
     * Method to deposit money into the account. This method will charge a fee if too much money is being deposited and will also notify the user if the amount deposited is invalid.
     * @param deposit Amount to be deposited
     */
    public void deposit(double deposit){
        if (deposit > 0){
            if (deposit > 20000){
                System.out.println("Deposits over $20,000 are charged a 1% fee. Do you wish to continue? \nPress 1 if you wish to continue.");
                int userInput = input.nextInt();
                if (userInput == 1){
                    double fee = deposit * .01;
                    this.balance += deposit - fee;
                }
                else {
                    System.out.println("Deposit cancelled.");
                }
            }
            else{
                this.balance += deposit;
                System.out.println("Deposit successful.");
            }
        }
        else{
            System.out.println("Deposit cancelled. Cannot deposit a negative amount.");
        }
    }


    /**
     * Method to withdraw money from the account. This method will charge a fee if too much money is being withdrawn and will also notify the user if the amount withdrawn is invalid.
     * @param withdrawal Amount to be withdrawn
     */
    public void withdraw(double withdrawal){
        if (withdrawal > 20000){
            System.out.println("Withdrawals over $20,000 are charged a 1% fee. Do you wish to continue? \nPress 1 if you wish to continue.");
            int userInput = input.nextInt();
            if (userInput == 1){
                double fee = withdrawal * .01;
                this.balance -= withdrawal + fee;
            }
            else{
                System.out.println("Withdrawal cancelled.");
            }
        }
        else{
            this.balance -= withdrawal;
            System.out.println("Withdrawal successful.");
        }
    }

    /**
     * Method to charge an overdraft fee if the balance in the account is below 0.
     */
    public void overdraft() {
        if(this.balance < 0){
            this.balance -= 25;
        }
    }


    /**
     * Method to validate account or routing numbers. This method ensures that the number is the proper length (9-digits) and is unique.
     * @param num Account or routing number to be validated
     * @return Boolean value determining whether the number is valid or not
     */
    public static boolean validateNum(int num){
        if (String.valueOf(num).length() != 9)
            return false;
        else if (nums.contains(num))
            return false;
        else
            return true;
    }

}