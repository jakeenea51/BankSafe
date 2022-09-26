import java.util.*;
public class BankSafe_Demo {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        
        
        //test accounts
        Checking_F2022_BankSafe johnSmithChecking = new Checking_F2022_BankSafe("John", "Smith", "111111111", 5000);
        Savings_F2022_BankSafe johnSmithSavings = new Savings_F2022_BankSafe("John", "Smith", "222222222", 10000); 
        Checking_F2022_BankSafe sarahLeeChecking = new Checking_F2022_BankSafe("Sarah", "Lee", "333333333", 2000);
        Savings_F2022_BankSafe sarahLeeSavings = new Savings_F2022_BankSafe("Sarah", "Lee", "444444444", 6500);


        System.out.println("Please make a selection from the following \n 1 - Log into Account \n 2 - Create Account \n 3 - Quit");
        int userInput = input.nextInt();
        
        if (userInput == 1){
            System.out.println("Input the account number: ");
            int accountInput = input.nextInt();
            System.out.println("Welcome what would you like to do?");
            System.out.println("1 - View your balance");
            System.out.println("2 - Deposit funds");
            System.out.println("3 - Withdraw funds");
            System.out.println("4 - Transfer funds from account");
            System.out.println("5 - Freeze account changes");
        int userInput2 = input.nextInt();

            if (userInput2 == 1){
                Double balance= 0.0;
                System.out.println("Your balance is : "+ balance);

            }
            else if (userInput2 == 2){
                     Double balance= 0.0;
            System.out.println("How much would you like to deposit?");
                    Double DepositA = input.nextDouble();
                                System.out.println("Your new balance is :"+ (balance +DepositA));

            }
            else if (userInput2 == 3){
                   Double balance= 0.0;
            System.out.println("How much would you like to withdraw?");
                    Double WithdrawA = input.nextDouble();
                                System.out.println("Your new balance is :"+ (balance - WithdrawA));
            }
            else if (userInput2 == 4){
                Double balance= 0.0;

                System.out.println("Insert Routing number of recieving account");
                int receivingAcc = input.nextInt();
                
                double TransferA = input.nextDouble();
                if(TransferA> balance){
                    System.out.println("Invaild transaction (Transfer amount exceeds balance");
                }
                else{
                double Foreignaccount = 0;
                double Newforeignaccount = Foreignaccount + TransferA;

                System.out.println("Transfer complete.");
                System.out.println("Your new balance is :"+ (balance - TransferA));
            }
        }
            else if (userInput2 == 5){
            System.out.println("Account Frozen");

            }
            /*
            System.out.println("Select integer for given account action:");
            System.out.println("1. View routing number.");
            System.out.println("2. View account balance.");
            System.out.println("3. Withdraw from account");
            System.out.println("4. Deposit into account");
            System.out.println("5. Transfer funds from account");
            System.out.println("6. Freeze account changes");
            */
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

        
        // Savings_F2022_BankSafe account1 = new Savings_F2022_BankSafe("Jake", "Enea", "000001", 3000);
        // account1.deposit(200.00);

        // System.out.println("Account Number: " + account1.getAccountNum());
        // System.out.println("This account belongs to " + account1.getFName() + " " + account1.getLName());
        // System.out.println("Account balance: " + account1.getBalance());

    }
}


        

