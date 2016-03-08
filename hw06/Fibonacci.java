// Eddison Ugaddan
// March 7, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW06: Fibonacci program takes in user input as three positive Integers,
//  the first two inputs being two integers consecutive in the Fibonacci 
//  sequence, and the third input being how many Fibonacci numbers to print out

import java.util.Scanner;   //import Scanner class for getting user input

public class Fibonacci{
    public static void main(String[] args){
        //initialize all the variables!
        Scanner scan;
        String requestMsg1;
        String requestMsg2;
        String requestMsg3;
        String errorMsg;
        boolean validInput1;
        boolean validInput2;
        boolean validInput3;
        int input1 = 0;
        int input2 = 0;
        int input3 = 0;
        
        int fib1;
        int fib2;
        int nextFib;
        int countFibs = 1;
        
        requestMsg1 = "Please enter the first number in the Fibonacci sequence: ";
        requestMsg2 = "Please enter the second number in the Fibonacci sequence: ";
        requestMsg3 = "How many Fibonacci numbers do you want printed to screen?: ";
        errorMsg = "Positive integers only... try again!";
        
        validInput1 = false;
        validInput2 = false;
        validInput3 = false;
        
        /*>>>nested while and if-statements below request user input,
            prints an error IF the input is non-Integer,
            ELSE the input is assigned to its corresponding int variable;
            while loop is broken out of only when all three inputs are Integer-only
        */  
        //loop while all three inputs are presumably invalid
        while (validInput1 == false || validInput2 == false || validInput3 == false ){ 
            scan = new Scanner(System.in);
            System.out.print(requestMsg1);
            if (!scan.hasNextInt()){
                System.out.println(errorMsg);
            }//end if statement
            else {  
                input1 = scan.nextInt();
                validInput1 = true;
                //loop while latter two inputs are presumably invalid
                if (input1 <= 0){
                    validInput1 = false;
                    System.out.println(errorMsg);
                }
                else {
                while (validInput2 == false || validInput3 == false){   
                    scan = new Scanner(System.in);
                    System.out.print(requestMsg2);
                    if (!scan.hasNextInt()){
                        System.out.println(errorMsg);
                    }//end if statement
                    else {
                        input2 = scan.nextInt();
                        validInput2 = true;
                        if (input2 <= 0){
                            validInput2 = false;
                            System.out.println(errorMsg);
                        }
                        else {
                        //loop while last input is presumably invalid
                        while (validInput3 == false){
                            scan = new Scanner(System.in);
                            System.out.print(requestMsg3);
                            if (!scan.hasNextInt()){
                                System.out.println(errorMsg);
                            }//end if statement
                            else {
                                input3 = scan.nextInt();
                                validInput3 = true;
                                if (input3 <= 0){
                                    validInput3 = false;
                                    System.out.println(errorMsg);
                                }
                            }//end else statement
                        }//end one-condition while loop
                        }
                    }//end else statement
                }//end two-condition while loop
                }
            }//end else statement
        }//end three-condition while loop
        
        fib1 = input1;  //initialize temporary placeholder variable for current input1
        fib2 = input2;  //initialize temporary placeholder variable for courrent input2
        System.out.println();           //print new line
        
        /*>>>nested while, if, and switch-statements below checks for special cases,
            otherwise generates a Fibonacci sequence using the while loop
            until the desired position in the sequence is reached
        */
        while (countFibs <= input3){    //loop until number of Fibonacci numbers printed
                                        //  matches desired printed elements
            if (input3 == 1){           //did user desire printing one Fibonacci number?
                System.out.print(fib1); //prints first number in Fibonacci sequence
                break;
            }//end if statement
            else if (input3 == 2){      //did user desire printing two Fibonacci numbers?
                System.out.print(fib1 + ", " + fib2);   //prints first two numbers in sequence
                break;   
            }//end else if statement
            else {  //otherwise user desired printing more than two Fibonacci numbers
                switch (countFibs) {    //compare counter for index position corresponding to
                                        //  next Fibonacci number to be printed
                    case(1):            //is the first Fibonacci - given by 
                                        //  user input - to be printed?
                        System.out.print(fib1 + ", ");  //prints first number in sequence
                        countFibs++;    //increment counter by 1
                        break;
                    case(2):            //is the second Fibonacci - given by
                                        //  user input - to be printed?
                        System.out.print(fib2 + ", ");  //is the second Fibonacci - given by 
                                                        //  user input - to be printed?
                        countFibs++;    //increment counter by 1
                        break;
                    default:            //the next Fibonacci in the sequence must be generated
                                        //  by the sum of the previous two Fibonacci numbers
                        nextFib = fib1 + fib2;  //assign the next Fibonacci to be printed
                        if (countFibs == input3){   //is loop on the last Fibonacci to be printed?
                            System.out.print(nextFib);  //print next Fibonacci with no punctuation
                                                        //  ...allows period to be printed after 
                                                        //  break out of while loop
                        }//end if statement
                        else {          //otherwise looping somehwere in the middle of the sequence
                            System.out.print(nextFib + ", ");   //print next Fibonacci with punctuation
                            fib1 = fib2;    //reassign these temporary placeholder variables to their 
                            fib2 = nextFib; //  corresponding next consecutive Fibonacci in the sequence
                        }//end else
                        countFibs++;    //increment counter by 1
                        break;
                }//end switch statement
            }//end else statement
        }//end while loop
        System.out.println(".");        //print period marking end of Fibonacci sequence
    }//end main method
}//end class