import java.util.*;

public abstract class Account_F2022_BankSafe extends User_F2022_BankSafe{

    public static Random random = new Random();
    public int accountNum, routingNum;
    public double balance = 0;
    public boolean frozen = false;

    Scanner input = new Scanner(System.in);


    //constructors
    //default
    public Account_F2022_BankSafe(){
    }

    //with name
    /**
     * @param accountNum This is the account's identification number
     * @param routingNum This is the account's routing number
     */
    public Account_F2022_BankSafe(double accountNum, double routingNum){
        this.accountNum = generateAccountNum();
        this.routingNum = generateRoutingNum();
    }


    //get and set methods
    public int getAccountNum(){
        return accountNum;
    }

    public void setAccountNum(int accountNum){
        this.accountNum = accountNum;
    }
    
    public int getRoutingNum(){
        return routingNum;
    }

    public void setRoutingNum(int routingNum){
        this.routingNum = routingNum;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public boolean isFrozen(){
        return frozen;
    }

    public void setFrozen(boolean frozen){
        this.frozen = frozen;
    }


    //method to generate an account number
    public static int generateAccountNum(){
        return 100000000 + random.nextInt(900000000);
    }

    public static int generateRoutingNum(){
        return 100000000 + random.nextInt(900000000);
    }



    //deposit method
    /**
     * @param deposit The amount the user would like to deposit
     * @return Nothing
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


    //withdraw method
    /**
     * @param withdrawal
     * @return Nothing
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

    // Overdraft methods
    public void overdraft() {
        if(this.balance < 0){
            this.balance -= 25;
        }
    }

}