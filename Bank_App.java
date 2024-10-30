import java.util.Scanner;

public class Bank_App {

        static Scanner Sn = new Scanner(System.in);

        public static void main(String[] args) {
                  //||||||||||||||||||
                  /**
                  *    ||Banking Application||
                  * @author Bilal ~
                   */
                //||||||||||||||||||

            System.out.println("  |  "+"Hello & Welcome To Bank's Gone ".toUpperCase()+"  |  "); //Welcoming Script
            System.out.println("  |  "+"Please Enter Your PIN Code".toUpperCase()+"  |  ");    //Entering PIN Script
            String _PIN_ = "";
            System.out.print("\t PIN: "); _PIN_ = Sn.next();                //PIN Number
            int times = 0;                                                          // The times that PIN Code Wrote Wrong (PIN Doesn't Equal To The Actual PIN or User Entered Less/More Digits
            if (_PIN_.equals("0242") && _PIN_.length() == 4) {           //To Check If The PIN Right/Wrong && To limit User
                                                                              //From Entering More Than 4 Digits
                System.out.println();
                Bank_Account();

            } else if (!(_PIN_.equals("0242")) || _PIN_.length() > 4 || _PIN_.length() <4) {
                while (times != 3) {
                    System.out.println();
                    System.out.println("  |  "+"Incorrect PIN Please Enter Your PIN Again".toUpperCase()+ "  |  ");
                    System.out.print("\t PIN: ");_PIN_ = Sn.next();  //PIN Number
                    if (_PIN_.equals("0242") && _PIN_.length() == 4) {
                                                                                                   //Like Any Real Bank It Has Limits Of Retries
                        Bank_Account(); //This To Call The Method Bank_Account
                    } else {                                                                        // 3 Times Than Account Will Be Closed
                        times++;

                    }
                }
                System.out.println();
                System.out.println("  |  "+"Account Has Been closed Contact The Bank".toUpperCase()+ "  |  ");


            }
        }


        public static void Bank_Account() {
            String Choice=""; //Input Of Which Choice User Will Choose
            int Money = 0;  // Input Of How Much Money
            int Amount = 0; //Output Of How Much Money
            while (true) {  // It Will Loop Until User Write Number 4
                System.out.println();
                System.out.println("  |  "+"Please Choose Which Operation Would You Like To Do".toUpperCase()+"  |  ");       //Output To The User
                System.out.println("\n\tMoney Deposit \t[ 1 ]\n\tMoney Withdrawal [ 2 ]\n\tSeeing Amount \t[ 3 ]\n\tExit [ 4 ]".toUpperCase()); //Choices That Users Can See & Choose
                System.out.print("\t Choice: ".toUpperCase()); Choice = Sn.next(); // Input Of What Number User will Choose
                if (Choice.length() == 1) {  //Once Again To Limit User From Entering More than 1 digit
                    if(Choice.equals("1") || Choice.equals("2") || Choice.equals("3") || Choice.equals("4") ) {  // To Make User Choose Between 1-4
                        switch (Choice) {    // Choices That User Will Choose

                            case "1":
                                System.out.println("  |  " + "How Much Money Will you Deposit".toUpperCase()+ "  |  ");  //Asking User Of How Much Input They Will Put
                                System.out.print("\t Amount: ".toUpperCase());
                                Money = Sn.nextInt();
                                Amount = +Money;                          //Adding Money to the Account
                                 System.out.println("\t|Please Wait|\n".toUpperCase());

                                try {
                                    for (int i = 0; i <= 10; i++) {
                                        Thread.sleep(1000);                                  //As We Know Banks Make Us Wait Until The Deposit Is Completed
                                        if (i < 4 || i > 4 && i != 10) System.out.print(".");         //It Makes User Wait For 10 Sec
                                        if (i == 4) {                                              //When It Reaches Specific Number It Will Add New Output
                                            System.out.print("Almost Done".toUpperCase());
                                        }
                                    }
                                } catch (InterruptedException ie) {
                                    Thread.currentThread().interrupt();
                                }

                                System.out.println();

                                System.out.println("  |  " + "Money Has Been Deposited! ".toUpperCase() + "  |  "); //Output Of Successful Operation
                                break;

                            case "2":
                                System.out.println("  |  " + "How Much Money Will You Withdrawal".toUpperCase() + "  |  "); //Asking User Of How Much Input They Will Put
                                System.out.print("\t Amount: ");
                                Money = Sn.nextInt();
                                if (Money > Amount || Amount == 0) {                                //Same Concept But Before Deposit It Check How Much Money The User Have
                                    System.out.println("  |  " + "You do not have enough balance to make a withdrawal".toUpperCase() + "  |  " + ":("); //Then Decide If User Can or Can't Withdraw
                                    break;
                                } else
                                    Amount = Amount - Money;                                        //Giving User The Money
                                  System.out.println("\t|Please Wait|\n".toUpperCase());

                                try {                                    //It Makes User Wait For 5 Sec
                                    for (int i = 0; i <= 5; i++) {
                                        Thread.sleep(1000);
                                        System.out.print(".");
                                    }
                                } catch (InterruptedException ie) {
                                    Thread.currentThread().interrupt();
                                }
                                System.out.println();
                                System.out.println("  |  " + "The money has been successfully withdrawn".toUpperCase() + "  |  " + ":)"); //Output Of Successful Operation
                                break;

                            case "3":
                                if (Amount == 0) {
                                    System.out.println("\t Sorry There's Not Enough Money".toUpperCase());  // If Amount Is Zero User Cannot View Their Money Amount
                                } else
                                    System.out.println("\t Your Amount: ".toUpperCase() + Amount + "$");   // Showing Money Amount
                                break;

                            case "4":
                                System.out.println("\t Thanks For visiting Bank's Gone".toUpperCase());  // Thanking User
                                System.exit(0);                                                     //Stopping The Compiler
                        }


                    }else {System.out.println("\t Error Choice Should Be Around 1-4".toUpperCase());}  // If Intro If_Statement False Then This Kind Of Output Will Be Shown To The User
                } else {
                    System.out.println("\t Error Please Write Only one Digit ".toUpperCase());   // If Outro If_Statement False Then This Kind Of Output Will Be Shown To The User
                }

            }
        }

    }


