import java.util.*;
public class BankSafe_Demo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        
        //test accounts
        ArrayList<Account_F2022_BankSafe> accounts = new ArrayList<Account_F2022_BankSafe>();
        accounts.add(new Checking_F2022_BankSafe("John", "Smith", 111111111, 5000));
        accounts.add(new Savings_F2022_BankSafe("John", "Smith", 222222222, 10000)); 
        accounts.add(new Checking_F2022_BankSafe("Sarah", "Lee", 333333333, 2000));
        accounts.add(new Savings_F2022_BankSafe("Sarah", "Lee", 444444444, 6500));

        System.out.println("Please make a selection from the following \n 1 - Log into Account \n 2 - Create Account \n 3 - Quit");
        int userInput = input.nextInt();
        
        if (userInput == 1){
            System.out.println("Input the account number: ");
            double accountNumInput = input.nextDouble();
            for (Account_F2022_BankSafe a : accounts){
                if (accountNumInput == a.getAccountNum()){
                    returningUserMenu(a);
                }
            }

        }
        else if (userInput == 2){
            System.out.println("Type 1 to create a checking account or 2 to create a savings account");

            if (userInput == 1){                                                //For checking account creation
                System.out.println("Enter your name first name");
                String fName = input.next();
                System.out.println("Enter your name last name");
                String lName = input.next();

                double Accountnum=Math.floor(Math.random() * 999999999)+100000000;  //Makes and displays random 9 digit Account and Routing number 
                System.out.println("Your Account number is: "+ Accountnum);

            double Routingnum=Math.floor(Math.random() * 999999999)+100000000;
            System.out.println("Your Routing number is: "+ Routingnum);
            
            System.out.println("Your account details read:");       //Displays all account details
                   System.out.println(fName+""+lName);
                    System.out.println("Routing number: "+Routingnum);
                    System.out.println("Account number: "+Accountnum);

            }

            else if(userInput == 2){                                            //For Savings account creation
                System.out.println("Enter your name first name");
                   String fName = input.next();
            
            System.out.println("Enter your name last name");
                   String lName = input.next();

            double Accountnum=Math.floor(Math.random() * 999999999)+100000000;
            System.out.println("Your Account number is: "+ Accountnum);

            double Routingnum=Math.floor(Math.random() * 999999999)+100000000;
            System.out.println("Your Routing number is: "+ Routingnum);
            
            System.out.println("Your account details read:");
            }
        
        }
        else if (userInput == 3){
            System.out.println("Thank you, have a nice day.");
        }
        else {
            System.out.println("Invalid option. Please try again.");
        }

        input.close();
    }


    //method to display returning user menu
    private static void returningUserMenu(Account_F2022_BankSafe userAccount){

        System.out.println("\nWelcome, " + userAccount.getFName() + " " + userAccount.getLName() + ", what would you like to do?");
        Scanner input = new Scanner(System.in);
        int userInput = 0;
        while (userInput != 6){
            System.out.println("\n1 - View your balance");
            System.out.println("2 - Deposit funds");
            System.out.println("3 - Withdraw funds");
            System.out.println("4 - Transfer funds from account");
            System.out.println("5 - Freeze/unfreeze account changes");
            System.out.println("6 - Exit account menu");
            userInput = input.nextInt();

            if (userInput == 1){
                System.out.println("\nYour balance is : "+ userAccount.getBalance());
            }

            else if (userInput == 2){
                System.out.println("\nYour current balance is : "+ userAccount.getBalance());
                System.out.println("How much would you like to deposit?");
                userAccount.deposit(input.nextDouble());
                System.out.println("Your new balance is : " + userAccount.getBalance());
            }

            else if (userInput == 3){
                System.out.println("\nYour current balance is : "+ userAccount.getBalance());
                System.out.println("How much would you like to withdraw?");
                userAccount.withdraw(input.nextDouble());
                System.out.println("Your new balance is : "+ userAccount.getBalance());
            }

            else if (userInput == 4){
                Double balance= 0.0;
                System.out.println("\nInsert Routing number of recieving account");
                int receivingAcc = input.nextInt();
                double TransferA = input.nextDouble();
                if(TransferA> balance){
                    System.out.println("\nInvaild transaction (Transfer amount exceeds balance");
                }
                else{
                    double Foreignaccount = 0;
                    double Newforeignaccount = Foreignaccount + TransferA;

                    System.out.println("\nTransfer complete.");
                    System.out.println("Your new balance is :"+ (balance - TransferA));
                }

            }
            else if (userInput == 5){
                if (!userAccount.isFrozen()){
                    userAccount.setFrozen(true);
                    System.out.println("\nAccount has been frozen.");
                }
                else{
                    userAccount.setFrozen(false);
                    System.out.println("\nAccount has been unfrozen.");
                }
            }

            else if (userInput == 6){
                System.out.println("\nThanks for stopping by, " + userAccount.getFName() + " " + userAccount.getLName() + ", have a great day!");
                return;
            }
            else {
                System.out.println("Invalid option. Please select an option from the list.");
            }
        }

        input.close();
    }

}


        

