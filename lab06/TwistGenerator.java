// Eddison Ugaddan
// March 4, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// Lab 6: TwistGenerator program gets Integer type input from user, and prints out 'twist' made up of \ / and X
//  characters spanning a length set by the number typed in by the user

import java.util.Scanner;   //import Scanner class for getting user input

public class TwistGenerator{
    public static void main(String[] args){
        int length = 0;     //initialize Integer variable for twist length
        String requestMsg = "Please enter twist length (whole numbers only!)";  //initialize String variable
                                                                                //  for input request message
        String requestHeader = ">> ";   //initialize String variable for input header
        String errorMsg = "Whole number positive integers only!  Try again!";   //initialize String variable
                                                                                //  for error message
        
        String twistTop = "\\ /";   //initialize String variable for top line of a block of twist
        String twistMid = " X ";    //initialize String variable for middle line of a block of twist
        String twistBot = "/ \\";   //initialize String variable for bottom line of a block of twist
        
        int counter = 0;    //initialize Integer variable for counting number of blocks already printed
        int resets = 0;     //initialize Integer variable for number of times counter variable 
                            //  has been reset to zero
        
        int blocks;         //initialize Integer variable for blocks/chunks of twist to be printed
        int trims;          //initialize Integer variable for any trimmings/leftover twist to be printed
        
        boolean validInt;   //initialize boolean variable as condition for while loop below
        validInt = false;   //assign boolean validInt as false... allowing break out of 
                            //  while loop below by setting validInt == true
        
        System.out.println(requestMsg);     //prints request for user input
        while (validInt == false) {         //>>>loop while valid input was not encountered - 
                                            //  break out when valid input is encountered
            System.out.print(requestHeader);        //prints request header '>> '
            Scanner scan = new Scanner(System.in);  //initialize Scanner Object... new Object 
                                                    //  each reloop in while() loop
            
            if (scan.hasNextInt()) {        //can an Integer token be found in input?
                length = scan.nextInt();    //assign next Integer token to variable 'length'
                if (length > 0) {             //was inputted integer positive and greater than 0?
                    validInt = true;        //allow exit out of while() loop
                    scan.close();           //terminate Scanner 'scan'
                }
                else {
                    System.out.println(errorMsg);   //prints error message
                }
            }//end if-statement
            else {
                System.out.println(errorMsg);       //prints error message
            }//end else-statement
        }//end while loop
        
        blocks = length/3;  //assign the number of times 3 can wholly divide into twist length
        trims = length%3;   //assign the remainder left after dividing 3 into twist length
        
        while (counter <= blocks && resets < 3) {   //>>>loop while there are blocks to be printed AND 
                                                    //  counter variable has not been reset as many 
                                                    //  times as there are lines to be printed
            switch (resets) {   //switch-statement to follow different sets of instructions depending 
                                //  on the number of times counter variable has been reset
                case 0: //when counter variable has been reset 0 times
                    if (blocks > 0) {           //when there are blocks to print...
                    System.out.print(twistTop); //print a block of the top line of twist
                    counter++;                  //increment counter   
                    }//end if-statement
                    if (counter == blocks) {    //when counter variable has matched the number of 
                                                //  blocks to print...
                        System.out.print(twistTop.substring(0,trims));  //print leftover 
                                                                        //  top line twist
                        counter = 0;            //reset counter to 0
                        resets++;               //increment the times counter has been reset
                        System.out.println(""); //print new line
                    }//end if-statement
                    break;
                case 1: //when counter variable has been reset 1 time
                    if (blocks > 0) {           //when there are blocks to print...
                        System.out.print(twistMid); //print a block of the middle line of twist
                        counter++;              //increment counter
                    }//end if-statement
                    if (counter == blocks) {    //when counter variable has matched the number of 
                                                //  blocks to print...
                        System.out.print(twistMid.substring(0,trims));  //print leftover 
                                                                        //  middle line twist
                        counter = 0;            //reset counter to 0
                        resets++;               //increment times counter has been reset
                        System.out.println(""); //print new line
                    }//end if-statement
                    break;
                default: //default to represent when counter variable has been reset 3 times
                    if (blocks > 0) {           //when there are blocks to print...
                        System.out.print(twistBot); //print a block of the bottom line of twist
                        counter++;              //increment counter
                    }//end if-statement
                    if (counter == blocks) {    //when counter variable has matched the number of 
                                                //  blocks to print...
                        System.out.print(twistBot.substring(0,trims));  //print leftover  
                                                                        //  bottom line twist
                        counter = 0;            //reset counter to 0
                        resets++;               //increment times counter has been reset
                        System.out.println("");
                    }//end if-statement
                    break;
            }//end Switch statement    
        }//end while loop
    }//end main method
}//end class