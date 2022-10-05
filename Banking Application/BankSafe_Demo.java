import java.util.*;
import java.io.*;
public class BankSafe_Demo {

    static Scanner input = new Scanner(System.in);
    static File file = new File("CSS1035-Code/Banking Application/accounts.txt");

    public static void main(String[] args) throws Exception{        

        //import accounts from csv
        Scanner fileIn = new Scanner(file);
        
        ArrayList<Account_F2022_BankSafe> accounts = new ArrayList<Account_F2022_BankSafe>();

        while (fileIn.hasNext()){
            String accountType = fileIn.next();
            String fName = fileIn.next();
            String lName = fileIn.next();
            double balance = fileIn.nextDouble();
            int accountNum = fileIn.nextInt();
            int routingNum = fileIn.nextInt();
            boolean frozen = fileIn.nextBoolean();
            if (accountType.equals("checking")){
                accounts.add(new Checking_F2022_BankSafe(fName, lName, balance, accountNum, routingNum, frozen));
            }
            else if (accountType.equals("savings")){
                accounts.add(new Savings_F2022_BankSafe(fName, lName, balance, accountNum, routingNum, frozen));
            }
            fileIn.nextLine();
        }

        fileIn.close();


        System.out.println("Welcome to the BankSafe ATM!");

        int userInput = 0;
        while (userInput != 3){
            System.out.println("");
            System.out.println("Please make a selection from the following: ");
            System.out.println(" 1 - Log into account");
            System.out.println(" 2 - Create account");
            System.out.println(" 3 - Quit");
            userInput = input.nextInt();
            
            if (userInput == 1){
                System.out.println("Input the account number: ");
                int accountNumInput = input.nextInt();
                for (Account_F2022_BankSafe a : accounts){
                    if (accountNumInput == a.getAccountNum()){
                        returningUserMenu(a);
                    }
                }

            }
            else if (userInput == 2){
                Account_F2022_BankSafe newAccount = (createNewAccountMenu());
                if (newAccount != null){
                    accounts.add(newAccount);
                }

            }
            else if (userInput == 3){
                System.out.println("\nThank you, have a nice day.");
                input.close();
                save(accounts);
            }

            else {
                System.out.println("\nInvalid option.");
            }
        }
    }


    //method to display returning user menu
    private static void returningUserMenu(Account_F2022_BankSafe userAccount){

        System.out.println("\nWelcome, " + userAccount.getFName() + " " + userAccount.getLName() + ", what would you like to do?");
        int userInput = 0;
        while (userInput != 6){
            System.out.println("");
            System.out.println(" 1 - View your balance");
            System.out.println(" 2 - Deposit funds");
            System.out.println(" 3 - Withdraw funds");
            System.out.println(" 4 - Transfer funds from account");
            System.out.println(" 5 - Freeze/unfreeze account changes");
            System.out.println(" 6 - Exit account menu");
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
    }


    private static Account_F2022_BankSafe createNewAccountMenu(){

        int userInput = 0;
        while (userInput != 3){
            System.out.println("\n 1 - Create a checking account");
            System.out.println(" 2 - Create a savings account");
            System.out.println(" 3 - Back to main menu");
            userInput = input.nextInt();

            if (userInput == 1){                                                //For checking account creation
                System.out.println("\nEnter your name first name");
                String fName = input.next();
                System.out.println("\nEnter your name last name");
                String lName = input.next();

                Checking_F2022_BankSafe newAccount = new Checking_F2022_BankSafe(fName, lName);
                System.out.println("\nYour account details read: ");       //Displays all account details
                System.out.println(newAccount.getFName() + " " + newAccount.getLName());
                System.out.println("Account number: "+ newAccount.getAccountNum());
                System.out.println("Routing number: "+ newAccount.getRoutingNum());
                return newAccount;
            }

            else if(userInput == 2){                                            //For Savings account creation
                System.out.println("\nEnter your name first name");
                String fName = input.next();
                System.out.println("\nEnter your name last name");
                String lName = input.next();

                Savings_F2022_BankSafe newAccount = new Savings_F2022_BankSafe(fName, lName);
                System.out.println("\nYour account details read: ");       //Displays all account details
                System.out.println(newAccount.getFName() + " " + newAccount.getLName());
                System.out.println("Account number: "+ newAccount.getAccountNum());
                System.out.println("Routing number: "+ newAccount.getRoutingNum());
                return newAccount;
            }

            else if(userInput == 3){
                System.out.println("\nNew account creation cancelled.");
            }

            else{
                System.out.println("\nInvalid option.");
            }
        }
        return null;
    }

    private static void save(ArrayList<Account_F2022_BankSafe> accounts) throws Exception{
        PrintWriter fileOut = new PrintWriter(file);
        for (Account_F2022_BankSafe a : accounts) {
			if (a instanceof Checking_F2022_BankSafe) {
				fileOut.println("checking");
			}
			else if (a instanceof Savings_F2022_BankSafe) {
				fileOut.println("savings");
			}
            fileOut.println(a.getFName());
            fileOut.println(a.getLName());
            fileOut.println(a.getBalance());
            fileOut.println(a.getAccountNum());
            fileOut.println(a.getRoutingNum());
            fileOut.println(a.isFrozen());
            fileOut.println();
		}
        fileOut.close();
    }

}


        

