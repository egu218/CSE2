// Eddison Ugaddan
// March 17, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW07: Triangles program takes in one user input of an integer in range [5-30],
//  and prints a triangle made of numbers, each line consists of the number
//  'n' printed n times, where n is incremented on subsequent lines after each print -
//  up until n matches the user inputted number, whereupon n is decremented

import java.util.Scanner;   //import Scanner class for getting user input

public class Triangles{
    public static void main(String[] args){
        //initialize variables used for validating user input
        Scanner scan;
        String requestMsg;
        String errorIntMsg;
        String errorRangeMsg;
        int userNum;
        boolean validInput;
        
        requestMsg = "Enter an integer in range [5-30] inclusive: ";
        errorIntMsg = "Need an integer only!  Try again.";
        errorRangeMsg = "Must be in range [5-30] inclusive!  Try again.";
        userNum = 1;
        validInput = false;
        
        //>>>while loop below validates user input
        while (!validInput){   //run while validInput is false - break when true
            System.out.print(requestMsg);    //request 
            scan = new Scanner(System.in);      //  user input
            if (scan.hasNextInt()){     //first token is an Integer?
                userNum = scan.nextInt();   //assign first encountered Integer
                                                //  to userNum variable
                if (userNum >= 5 && userNum <= 30){  //userNum is in range?
                    validInput = true; //valid input for userNum found,
                                        //  allow exit out of this while loop
                }//end if statement
                else {  //error encountered!
                    System.out.println(errorRangeMsg);
                }//end else statement
                
            }//end if statement
            else {      //error encountered!
                System.out.println(errorIntMsg);
            }//end else statement
        }//end while loop
        
        //initialize variables used for printing lines
        String line;
        int lineCount;
        int charCount;
        int charRepeats;
        int repeatIncrement;
        line = "";
        charRepeats = 1;
        repeatIncrement = 1;
        
        System.out.println("\nFOR LOOP:");
        //>>>for loop below prints lines of chars,
        //  and reinitializes the appropriate variables to allow the nested 
        //  for loop to build the next line properly
        for (lineCount = 1; lineCount <= (userNum*2 - 1); lineCount++){
            if (charRepeats == userNum){    //number of chars to be printed on 
                                            //  this line has reached a maximum?
                repeatIncrement *= -1;      //flip the sign of the increment
            }
            //>>>for loop below builds a line
            for (charCount = 1; charCount <= charRepeats; charCount++){
                line += charRepeats;        //add chars to the line
            }//end for loop
            System.out.printf("%s\n",line); //print the last built line!
            line = "";                      //reset line String
            charRepeats += repeatIncrement; //increment/decrement number of
                                            //  chars to be printed
            if (charRepeats < 1){           //number of chars to be printed has
                                            //  decremented below 1?
                break;      //break out of outermost for loop
            }//end if statement
        }//end for loop
        
        
        //reinitialize variables
        line = "";
        lineCount = 1;
        charCount = 1;
        charRepeats = 1;
        repeatIncrement = 1;
        
        System.out.println("\nWHILE LOOP:");
        //>>>while loop below prints lines of chars,
        //  and reinitializes the appropriate variables to allow the nested 
        //  for loop to build the next line properly
        while (true){   //loop forever until break encountered
            if (charRepeats == userNum){    //number of chars to be printed on 
                                            //  this line has reached a maximum?
                repeatIncrement *= -1;      //flip the sign of the increment
            }//end if statement
            //>>>while loop below builds a line
            while (true){   //loop forever until break encountered
                if (charCount <= charRepeats){  //charCount is within operating limits?
                    line += charRepeats;    //add chars to the line
                }//end if statement
                else {                      //charCount must be outside operating limits!
                    break;  //break out of innermost while loop
                }//end else statement
                charCount++;                //increment charCoutn
            }//end while loop
            System.out.printf("%s\n",line); //print the last built line!
            line = "";                      //reset line String
            charRepeats += repeatIncrement; //increment/decrement number of
                                            //  chars to be printed
            charCount = 1;                  //reset charCount         
            if (charRepeats < 1){           //number of chars to be printed has
                                            //  decremented below 1?
                break;      //break out of outermost while loop
            }//end if statement
        }//end while loop
        
        
        //reinitialize variables
        line = "";
        lineCount = 1;
        charCount = 1;
        charRepeats = 1;
        repeatIncrement = 1;
        
        System.out.println("\nDO-WHILE LOOP:");
        //>>>do-while loop below prints lines of chars,
        //  and reinitializes the appropriate variables to allow the nested 
        //  for loop to build the next line properly
        do {   //loop forever until break encountered
            if (charRepeats == userNum){    //number of chars to be printed on 
                                            //  this line has reached a maximum?
                repeatIncrement *= -1;      //flip the sign of the increment
            }//end if statement
            //>>>do-while loop below builds a line
            do {   //loop forever until break encountered
                if (charCount <= charRepeats){  //charCount is within operating limits?
                    line += charRepeats;    //add chars to the line
                }//end if statement
                else {                      //charCount must be outside operating limits!
                    break;  //break out of innermost while loop
                }//end else statement
                charCount++;                //increment charCoutn
            } while (true);//end do-while loop
            System.out.printf("%s\n",line); //print the last built line!
            line = "";                      //reset line String
            charRepeats += repeatIncrement; //increment/decrement number of
                                            //  chars to be printed
            charCount = 1;                  //reset charCount         
            if (charRepeats < 1){           //number of chars to be printed has
                                            //  decremented below 1?
                break;      //break out of outermost while loop
            }//end if statement
        } while (true);//end do-while loop
        
    }//end main method
}//end class