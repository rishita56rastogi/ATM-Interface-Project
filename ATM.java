import java.util.Scanner;
public class ATM {
    private static final String[] TRANSACTIONS={"Deposit,Withdrawl,Transfer"};
        private static String userId="user123";
        private static String userPin="1234";
        private static double balance=1000.00;
        private static String transactionHistory = "";
        public static void main(String[] args) {
            Scanner scan=new Scanner(System.in);
            System.out.println("Welcome to the ATM");
            System.out.println("please enter your userId:" );
            String inputId=scan.nextLine();
            System.out.println("Please enter your pin:");
            String inputPin=scan.nextLine();
           
            if(inputId.equals(userId)&& inputPin.equals(userPin)){
                System.out.println("Login Successful.");
                boolean isRunning=true;
                while (isRunning) 
                {
                    System.out.println("\nSelect an option:");
                    System.out.println("1. View transaction History");
                    System.out.println("2. Withdraw");
                    System.out.println("3. Deposit");
                    System.out.println("4. Transfer");
                    System.out.println("5.  Quit");

                    int option = scan.nextInt();
                    switch(option){
                        case 1:
                        viewTransactionHistory();
                        break;
                        case 2:
                        withdraw(scan);
                        break;
                        case 3:
                        deposit(scan);
                        break;
                        case 4:
                        transfer(scan);
                        break;
                        case 5:
                        System.out.println("thankyou for using ATM.Goodbye!");
                        isRunning=false;
                        break;
                        default:
                        System.out.println("Invalid option.Please try again.");
                        break;
                    }
                  }
                }
                else{
                    System.out.println("invalid user id or pin.Please try again.");
                }
            }
            private static void viewTransactionHistory(){
                System.out.println("Transaction history:");
                System.out.println(transactionHistory);
            }
            private static void withdraw(Scanner scan){
                System.out.println("please enter the amount to withdraw:");
                double amount=scan.nextDouble();
                if(amount<=balance){
                    balance -= amount;
                    String transaction = String.format("%s of %.2f withdrawn\n",TRANSACTIONS[1], amount);
                    transactionHistory +=transaction;
                    System.out.printf("You have withdrawn %.2f\n",amount);
                    System.out.printf("Your current balance %.2f\n",balance);
                }else{
                    System.out.println("Insufficient funds");

                }
            }
            private static void deposit(Scanner scan){
                System.out.println("please enter the amount to deposit:");
                   double amount=scan.nextDouble();
                    balance += amount;
                    String transaction = String.format("%s of %.2f deposit\n",TRANSACTIONS[0], amount);
                    transactionHistory +=transaction;
                    System.out.printf("You have deposited %.2f\n",balance);
                    System.out.printf("You have current balance %.2f\n",balance);
                }
                private static void transfer(Scanner scan){
                    System.out.println("please enter the recipent's account number:");
                    String recipent=scan.next();
                    System.out.println("please enter the amount to transfer:");
                    double amount=scan.nextDouble();
                   
                    if(amount<=balance){
                        balance -= amount;
                        String transaction = String.format("%s of %.2f transferred to account%s\n",TRANSACTIONS[2], amount,recipent);
                        transactionHistory +=transaction;
                        System.out.printf("You have transferred %.2f to account %s\n",amount,recipent);
                        System.out.printf("You have current balance is %.2f\n",balance);
                    }else{
                        System.out.println("Insufficient fund.");
    
                    }
                }
            }

                
            

               



                    


                    
                