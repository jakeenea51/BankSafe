import java.util.*;

public abstract class Account_F2022_BankSafe{

    public String fName, lName;
    public double accountNum, routingNum;
    public double balance = 0;
    public boolean frozen = false;

    Scanner input = new Scanner(System.in);


    //constructors
    //default
    public Account_F2022_BankSafe(){
        this.accountNum = Math.floor(Math.random() * 999999999)+100000000;
        this.routingNum = Math.floor(Math.random() * 999999999)+100000000;
    }

    //with name
    public Account_F2022_BankSafe(String fName, String lName, double accountNum, double routingNum){
        this.fName = fName;
        this.lName = lName;
        this.accountNum = accountNum;
        this.routingNum = routingNum;
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

    public double getAccountNum(){
        return accountNum;
    }

    public void setAccountNum(double accountNum){
        this.accountNum = accountNum;
    }
    
    public double getRoutingNum(double routingNum){
        return routingNum;
    }

    public void setRoutingNum(double routingNum){
        this.routingNum = routingNum;
    }

    public double getBalance(){
        return balance;
    }

    public boolean isFrozen(){
        return frozen;
    }

    public void setFrozen(boolean frozen){
        this.frozen = frozen;
    }


    //deposit method
    public void deposit(double deposit){
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


    //withdraw method
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
        if(balance < 0){
            this.balance -= 25;
        }
    }

}