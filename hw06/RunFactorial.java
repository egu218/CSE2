// Eddison Ugaddan
// March 8, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW06: RunFactorial program takes in one user input [9-16], calculates the
//      factorial of it, and prints it out

import java.util.Scanner;   //import Scanner class for getting user input

public class RunFactorial{
    public static void main(String[] args){
        //initialize all the variables!
        Scanner scan;
        String requestMsg;
        String errorMsg;
        String validMsg;
        int inputNum;
        int multiplier;
        long factorial;     //must be data type long, as 13! exceeds Integer's
                            //  upper limit of +2,147,483,647
        
        requestMsg = "Please enter an integer between 9 and 16:";
        errorMsg = "Invalid input; try again!";
        validMsg = "Input accepted:";
        
        System.out.println(requestMsg); //print request for user input message
        
        /*>>>while loop below validates user input,
            by checking for non_Integer inputs,
            and by checking for an invalid Integer input range 
            outside [9,16]
        */
        while (true){   //always run until break encountered
            scan = new Scanner(System.in);  //assign new Scanner Object after every loop
            if (!scan.hasNextInt()) {       //non-Integer input encountered?
                System.out.println(errorMsg);       //prints error message
            }//end if statement
            else {  //Integer input encountered!
                inputNum = scan.nextInt();  //assign Integer input to variable
                if (inputNum < 9 || inputNum > 16){ //invalid range encountered?
                    System.out.println(errorMsg);   //prints error message
                }//end if statement
                else {  //valid range!
                    System.out.println(validMsg);   //prints valid input message
                    break;  //break out of while loop
                }//end if statement
            }//end else statement
        }//end while loop
        
        factorial = inputNum;           //assign starting number 
        multiplier = inputNum-1;        //assign multiplier as the starting 
                                        //  number minus 1
        System.out.println();           //print new line
        
        /*>>>while loop below calculates the factorial of the user inputted number,
            by multiplying the value of the input number by a 
            decrementing variable called 'multiplier'
        */
        while (multiplier > 0){         //is the factorial still being calculated?
            //System.out.print(" * " + multiplier + " ");
            factorial *= multiplier;    //looping allows this line to do this, 
                                        //  e.g.: 9*8*7*6*5*4*3*2*1
            multiplier--;               //decrement multiplier... allows 
                                        //break out of loop 
        }//end while loop
        System.out.printf("\n%d! = %d\n", inputNum, factorial); //prints final factorial
        
    }//end main method
}//end class