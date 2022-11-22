import java.util.*;
import java.io.*;

public class BankSafe_Demo {

    static Scanner input = new Scanner(System.in);
    static File file = new File("CSS1035-Code/Banking Application/accounts.txt");

    // EXAMPLE OF USING GENERICS - ArrayList only accepts objects of type User_F2022_BankSafe
    public static ArrayList<User_F2022_BankSafe> users = new ArrayList<User_F2022_BankSafe>();

    public static void main(String[] args) throws Exception {

        // output encoded to UTF-8
        System.setOut(new PrintStream(System.out, true, "UTF-8"));

        // decrypt accounts file
        Encryption.decryptFile(file);

        // import accounts from txt file
        Scanner fileIn = new Scanner(file);

        User_F2022_BankSafe newUser = new User_F2022_BankSafe();

        while (fileIn.hasNext()) {
            String type = fileIn.next();
            if (type.equals("user")) {
                String username = fileIn.next();
                String password = fileIn.next();
                String fName = fileIn.next();
                String lName = fileIn.next();
                newUser = new User_F2022_BankSafe(username, password, fName, lName);
                users.add(newUser);
                fileIn.nextLine();
            } else {
                double balance = fileIn.nextDouble();
                int accountNum = fileIn.nextInt();
                int routingNum = fileIn.nextInt();
                boolean frozen = fileIn.nextBoolean();
                if (type.equals("checking")) {
                    Checking_F2022_BankSafe checkingAccount = new Checking_F2022_BankSafe(balance, accountNum,
                            routingNum, frozen);
                    newUser.addAccount(checkingAccount);
                } else if (type.equals("savings")) {
                    Savings_F2022_BankSafe savingsAccount = new Savings_F2022_BankSafe(balance, accountNum, routingNum,
                            frozen);
                    newUser.addAccount(savingsAccount);
                }
            }

            fileIn.nextLine();
        }

        fileIn.close();

        // encrypt accounts file
        Encryption.encryptFile(file);

        System.out.println("Welcome to the BankSafe ATM!");

        int userInput = 0;
        while (userInput != 3) {
           //Do while loop is used to validate user input to ensure that input is an Integer rather than a string
            do{
                try{
                    System.out.println("");
                    System.out.println("Please make a selection from the following: ");
                    System.out.println(" 1 - Login to account");
                    System.out.println(" 2 - Create account");
                    System.out.println(" 3 - Quit");
                    userInput = input.nextInt();
                }
                // catches invalid option input
                catch (InputMismatchException ex){
                    System.out.println("\nInvalid option. Please select an option from the list.");
                    userInput = 0;
                }
                input.nextLine();
            } while (userInput == 0);
            

            // login to user account
            if (userInput == 1){
                boolean found = false;
                while (!found){
                    try{
                    found = true;
                    System.out.println("Username: ");
                    String username = input.next();
                    System.out.println("Password: ");
                    String password = input.next();
                    userMenu(User_F2022_BankSafe.login(username, password));
                    }
                    // catches invalid login
                    catch(InvalidLoginException ex){
                        System.out.println(ex);
                        found = false;
                    }
                }
            }
            else if (userInput == 2) {
                User_F2022_BankSafe newAccount = (createUserAccountMenu());
                if (newAccount != null) {
                    users.add(newAccount);
                }
            } 
            else if (userInput == 3) {
                System.out.println("\nThank you, have a nice day.");
                input.close();
                save(users);
            }
            else {
                System.out.println("\nInvalid option. Please select an option from the list.");
            }
        }
    }


    // method to display user account menu
    private static void userMenu(User_F2022_BankSafe user) {

        int userInput = 0;
        while (userInput != 4) {
            do{
                try{
                    System.out.println("\nWelcome, " + user.getFName() + " " + user.getLName() + ", what would you like to do?");
                    System.out.println(" 1 - Select account");
                    System.out.println(" 2 - Create new account");
                    System.out.println(" 3 - Change settings");
                    System.out.println(" 4 - Logout");
                    userInput = input.nextInt();
                }
                // catches invalid option input
                catch (InputMismatchException ex){
                    System.out.println("\nInvalid option. Please select an option from the list.");
                    userInput = 0;
                }
                input.nextLine();
            } while (userInput == 0);

            // display accounts and prompt user for account number of account they would
            // like to select
            if (userInput == 1) {
                if (user.userAccounts.isEmpty()) {
                    System.out.println("\nYou don't have any accounts.");
                } else {
                    System.out.println("\nYour accounts: ");
                    for (Account_F2022_BankSafe a : user.userAccounts) {
                        if (a instanceof Savings_F2022_BankSafe) {
                            System.out.println("\nSavings account:");
                        } else if (a instanceof Checking_F2022_BankSafe) {
                            System.out.println("\nChecking account:");
                        }
                        System.out.println("Account number: " + a.getAccountNum());
                        System.out.println("Balance: " + a.getBalance());
                    }

                    int userNum = 0;
                    boolean found = false;
                    while (!found) {
                        do{
                            try{
                                System.out.println("\nEnter the account number of the account you wish to select: ");
                                userNum = input.nextInt();
                            }
                            // catches invalid account number input
                            catch (InputMismatchException ex){
                                System.out.println("\nInvalid account number. Please select an account number from the list.");
                                userNum = 0;
                            }
                            input.nextLine();
                        } while (userNum == 0);

                        for (Account_F2022_BankSafe a : user.userAccounts) {
                            if (a.getAccountNum() == userNum) {
                                found = true;
                                accountMenu(a);
                            }
                        }
                        if (!found) {
                            System.out.println("\nInvalid account number. Please select an account number from the list.");
                        }
                    }

                }

            }

            else if (userInput == 2) {
                createBankAccountMenu(user);
            }

            // add ability to change name, username, and password
            else if (userInput == 3) {
                System.out.println("\nOption currently unavailable.");
            }

            else if (userInput == 4) {
                System.out.println(
                        "\nThanks for stopping by, " + user.getFName() + " " + user.getLName() + ", have a great day!");
                return;
            }

            else {
                System.out.println("\nInvalid option. Please select an option from the list.");
            }
        }

    }

    // method to display bank account menu
    private static void accountMenu(Account_F2022_BankSafe userAccount) {

        String type;
        if (userAccount instanceof Checking_F2022_BankSafe) {
            type = "Checking";
        } else {
            type = "Savings";
        }

        int userInput = 0;
        while (userInput != 6) {
            do{
                try{
                    System.out.println("\n" + type + " Account #" + userAccount.getAccountNum() + "\nWhat would you like to do?");
                    System.out.println(" 1 - View your balance");
                    System.out.println(" 2 - Deposit funds");
                    System.out.println(" 3 - Withdraw funds");
                    System.out.println(" 4 - Transfer funds from account");
                    System.out.println(" 5 - Freeze/unfreeze account changes");
                    System.out.println(" 6 - Exit account menu");
                    userInput = input.nextInt();
                }
                // catches invalid option input
                catch (InputMismatchException ex){
                    System.out.println("\nInvalid option. Please select an option from the list.");
                    userInput = 0;
                }
                input.nextLine();
            } while (userInput == 0);

            if (userInput == 1) {
                System.out.println("\nYour balance is : " + userAccount.getBalance());
            }

            else if (userInput == 2) {
                System.out.println("\nYour current balance is : " + userAccount.getBalance());
                System.out.println("How much would you like to deposit?");
                try{
                userAccount.deposit(input.nextDouble());
                System.out.println("Your new balance is : " + userAccount.getBalance());
                }
                // catches invalid negative amount
                catch(InvalidAmountException ex){
                    System.out.println(ex);
                }
            }

            else if (userInput == 3) {
                System.out.println("\nYour current balance is : " + userAccount.getBalance());
                System.out.println("How much would you like to withdraw?");
                try{
                    userAccount.withdraw(input.nextDouble());
                    System.out.println("Your new balance is : " + userAccount.getBalance());
                }
                // catches invalid negative amount 
                catch(InvalidAmountException ex){
                    System.out.println(ex);
                }
            }

            else if (userInput == 4) {
                Double balance = 0.0;
                System.out.println("\nInsert Routing number of recieving account");
                int receivingAcc = input.nextInt();
                double TransferA = input.nextDouble();
                if (TransferA > balance) {
                    System.out.println("\nInvaild transaction (Transfer amount exceeds balance");
                } else {
                    double Foreignaccount = 0;
                    double Newforeignaccount = Foreignaccount + TransferA;

                    System.out.println("\nTransfer complete.");
                    System.out.println("Your new balance is :" + (balance - TransferA));
                }

            } else if (userInput == 5) {
                if (!userAccount.isFrozen()) {
                    userAccount.setFrozen(true);
                    System.out.println("\nAccount has been frozen.");
                } else {
                    userAccount.setFrozen(false);
                    System.out.println("\nAccount has been unfrozen.");
                }
            }

            else if (userInput == 6) {
                return;
            } else {
                System.out.println("\nInvalid option. Please select an option from the list.");
            }
        }
    }

    private static Account_F2022_BankSafe createBankAccountMenu(User_F2022_BankSafe user) {

        int userInput = 0;
        while (userInput != 3) {
            do{
                try{
                    System.out.println("\n 1 - Create a checking account");
                    System.out.println(" 2 - Create a savings account");
                    System.out.println(" 3 - Back to main menu");
                    userInput = input.nextInt();
                }
                // catches invalid option input
                catch (InputMismatchException ex){
                    System.out.println("\nInvalid option. Please select an option from the list.");
                    userInput = 0;
                }
                input.nextLine();
            } while (userInput == 0);

            if (userInput == 1) { // For checking account creation

                System.out.println("\nAre you sure you would like to create a checking account? \n y - Yes \n n - No");
                String proceed = input.next();

                if (proceed.equals("y")) {
                    Checking_F2022_BankSafe newAccount = new Checking_F2022_BankSafe();
                    System.out.println("\nYour account details read: "); // Displays all account details
                    System.out.println("Account number: " + newAccount.getAccountNum());
                    System.out.println("Routing number: " + newAccount.getRoutingNum());
                    user.addAccount(newAccount);
                    return newAccount;
                } else {
                    System.out.println("\nChecking account creation cancelled.");
                }
            }

            // For Savings account creation
            else if (userInput == 2) {

                System.out.println("\nAre you sure you would like to create a savings account? \n y - Yes \n n - No");
                String proceed = input.next();

                if (proceed.equals("y")) {
                    Savings_F2022_BankSafe newAccount = new Savings_F2022_BankSafe();
                    System.out.println("\nYour account details read: "); // Displays all account details
                    System.out.println("Account number: " + newAccount.getAccountNum());
                    System.out.println("Routing number: " + newAccount.getRoutingNum());
                    user.addAccount(newAccount);
                    return newAccount;
                } else {
                    System.out.println("\nSavings account creation cancelled.");
                }
            }

            else if (userInput == 3) {
                System.out.println("\nNew account creation cancelled.");
            }

            else {
                System.out.println("\nInvalid option. Please select an option from the list.");
            }
        }
        return null;
    }

    private static User_F2022_BankSafe createUserAccountMenu() {

        String username = "";
        String password = "";

        System.out.println("Please enter your first name: ");
        String fName = input.next();
        System.out.println("Please enter your last name: ");
        String lName = input.next();

        boolean found = true;
        while (found) {
            found = false;
            System.out.println("Please enter a username for your account: ");
            username = input.next();
            for (User_F2022_BankSafe u : users) {
                if (u.getUsername().equals(username)) {
                    System.out.println("Username already taken.");
                    found = true;
                }
            }
        }

        boolean match = false;
        while (!match) {
            match = true;
            System.out.println("Please enter a password for your account: ");
            password = input.next();
            System.out.println("Please confirm your password: ");
            String confirmPassword = input.next();
            if (!password.equals(confirmPassword)) {
                System.out.println("Passwords do not match.");
                match = false;
            }
        }

        System.out.println("New account created.");
        return new User_F2022_BankSafe(username, Hash.hashPassword(password), fName, lName);

    }

    private static void save(ArrayList<User_F2022_BankSafe> users) throws Exception {
        
        // decrypt accounts file
        Encryption.decryptFile(file);

        PrintWriter fileOut = new PrintWriter(file);
        for (User_F2022_BankSafe u : users) {
            fileOut.println("user");
            fileOut.println(u.getUsername());
            fileOut.println(u.getPassword());
            fileOut.println(u.getFName());
            fileOut.println(u.getLName());
            fileOut.println();
            for (Account_F2022_BankSafe a : u.userAccounts) {
                if (a instanceof Checking_F2022_BankSafe) {
                    fileOut.println("checking");
                } else if (a instanceof Savings_F2022_BankSafe) {
                    fileOut.println("savings");
                }
                fileOut.println(a.getBalance());
                fileOut.println(a.getAccountNum());
                fileOut.println(a.getRoutingNum());
                fileOut.println(a.isFrozen());
                fileOut.println();
            }
        }
        fileOut.close();

        // encrypt accounts file
        Encryption.encryptFile(file);
    }

}
