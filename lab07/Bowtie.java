// Eddison Ugaddan
// March 11, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// Lab 7: Bowtie program prints a bowtie made of text, with width corresponding
//  to an inputted odd Integer in the range [3,33];
//  the bowtie is printed by: while loop, for loop, or do-while loop implementations

// NOTE: for loop and do-while loop implementations are commented out by 
//  separate "/* */" pairs, demarcated by the comment "REMOVE THIS LINE" 
//  - for testing purposes;
//  thusly insert "/* */" pairs where INSERT /* BELOW IF NEEDED or
//  INSERT */ ABOVE IF NEEDED comments are found
import java.util.Scanner;

public class Bowtie{
    public static void main(String[] args){
        //initialize all the variables!
        Scanner scan;
        String continueMsg;
        String requestMsg;
        String errorTypeMsg;
        String errorRangeMsg;
        String errorParityMsg;
        String starLine;
        String starChar;
        String space;
        String spaceChar;
        int nStarsInput;
        int nStars;
        int starsLimit;
        int starCount;
        int limitIncrement;
        
        continueMsg = "Continue?  Type 'Y' or 'y' - otherwise type anything else: ";
        requestMsg = "Enter an odd integer in range [3,33] inclusive: ";
        errorTypeMsg = "Invalid input type: must be Integer!  Try again...";
        errorRangeMsg = "Invalid input range: must be in [3,33]!  Try again...";
        errorParityMsg = "Invalid input parity: must be odd!  Try again...";
        starLine = "";          //String to be printed, holding "*" characters
        starChar = "*";         //character to be added onto starLine String
        space = "";             //String to be printed, holding " " or "\b" 
                                //  characters
        spaceChar = " ";        //character to be added onto space String
        
        continueLoop:
        while (true){    
            System.out.print(continueMsg);
            scan = new Scanner(System.in);
            if (scan.next().equalsIgnoreCase("y")) {
                
                //>>>while loop below checks for valid user input;
                //    non-Integer input is filtered out;
                //    Integer input outside [3,33] range is filtered out;
                //    even Integer input is filtered out
                //
                checkInput:     //label for while loop below
                while (true){   //loop forever until break encountered
                    System.out.print(requestMsg);   //prints request for user input message
                    scan = new Scanner(System.in);  //initialize new Scanner Object on each loop
                    if (scan.hasNextInt()){     //first token encountered is an Integer?
                        nStarsInput = scan.nextInt();    //assign encountered Integer to 
                                                        //  nStarsInput variable
                        if (nStarsInput >= 3 && nStarsInput <= 33){   //nStarsInput is within valid range?
                            if (nStarsInput%2 == 1){ //nStarsInput is an odd number?
                                break checkInput;   //break out of while loop labeled checkInput
                            }//end if statement
                            else {  //invalid input parity encountered!  ...break not encountered
                                    //  so reloop and allow nStars to be updated
                                System.out.println(errorParityMsg); //prints parity error message
                            }//end else statement
                        }//end if statement
                        else {  //invalid input range encountered!  ...break not encountered 
                                //  so reloop and allow nStars to be updated
                            System.out.println(errorRangeMsg);   //prints range error message
                        }//end else statement
                            
                    }//end if statement
                    else {
                        System.out.println(errorTypeMsg);       //prints type error message
                    }//end else statement
                }//end while loop labeled checkInput
                
                nStars = nStarsInput;   //max width of bowtie
                starsLimit = nStars;    //limit for the number of stars to be printed
                                        //  on the current line
                starCount = starsLimit; //number of stars to print
                limitIncrement = -2;    //how much starsLimit will be decremented
                                        //  or incremented by
                
                /*********************************************************************************
                 * Begin bowtie with while loop implementation ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                *********************************************************************************/
                // INSERT /* BELOW IF NEEDED 
                
                //>>>while loop below prints the appropriate number of space and "*"
                //    characters per line on each loop;
                //    top half of bowtie is printed before the condition starsLimit <= 1
                //    is met;
                //    bottom half of bowtie is printed after the condition starsLimt <= 1
                //    is met
                //
                loopLine:       //label for while loop below
                while (true){   //loop forever until break encountered
                    if (starsLimit > nStars){   //starsLimit updated to a value greater
                                                //  than initial nStars input?
                        break loopLine;         //break out of while loop labeled loopLine
                    }//end if statement
                    
                    //>>>while loop below adds a "*" to String starLine on each loop;
                    //    starsLimit is incremented or decremented accordingly under the 
                    //    condition that there are no more stars to be added onto the 
                    //    current line;
                    //
                    loopStars:  //label for while loop below
                    while (true){   //loop forever until break encountered
                        if (starCount < 1){     //no more "*" characters left to add
                                                //  onto the current line to be printed?
                            starsLimit += limitIncrement;   //decrement or increment starsLimit
                                                            //  depending on current sign of
                                                            //  limitIncrement
                            starCount = starsLimit;         //reinitialize starCount to updated 
                                                            //  starsLimit
                            break loopStars;    //break out of while loop labeled loopStars
                        }//end if statement
                        starLine += starChar;   //add "*" onto current line to be printed
                        starCount--;            //decrement number of "*" characters left
                                                //  to add onto current line to be printed
                    }//end while loop labeled loopStars
                    System.out.printf("%s%s\n",space,starLine); //print space and starLine Strings
                    space += spaceChar;         //adds " " onto space String when printing top half
                                                //  adds "\b" into space String when printing bottom
                    starLine = "";              //reset starLine String
                    if (starsLimit <= 1){       //starsLimit updated to a value less than or 
                                                //  equal to 1?
                        limitIncrement *= -1;   //reinitialize limitIncrement with a flipped sign
                        spaceChar = "\b";       //reinitialize spaceChar to backspace... allows
                                                //  deletion of previously added space " " chars
                                                //  to space String
                    }//end if statement
                }//end while loop labeled loopLine
                
                // INSERT */ ABOVE IF NEEDED 
                
                /*********************************************************************************
                 * End bowtie with while loop implementation ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                *********************************************************************************/
                
                /*********************************************************************************
                 * Begin bowtie with for loop implementation ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                *********************************************************************************/
                /* REMOVE THIS LINE
                //reinitialize significant variables to default settings
                spaceChar = " ";        //character to be added onto space String
                nStars = nStarsInput;   //max width of bowtie
                starsLimit = nStars;    //limit for the number of stars to be printed
                                        //  on the current line
                starCount = starsLimit; //number of stars to print
                limitIncrement = -2;    //how much starsLimit will be decremented
                                        //  or incremented by
                //for loop below: run contents for as long as lineIndex is <= nStars
                for (int lineIndex = 1; lineIndex <= nStars; lineIndex++){  
                    //for loop below: run contents for as long as starCount >= 1
                    for (starCount = starsLimit; starCount >= 1; starCount--){
                        starLine += starChar;   //add "*" onto current line to be printed
                    }//end for loop
                    System.out.printf("%s%s\n",space,starLine); //print space and starLine Strings
                    space += spaceChar;     //adds " " onto space String when printing top half
                                            //  adds "\b" into space String when printing bottom
                    starLine = "";          //reset starLine String
                    starsLimit += limitIncrement;   //decrement or increment starsLimit
                                                    //  depending on current sign of
                                                    //  limitIncrement
                    if (starsLimit <= 1){       //starsLimit updated to a value less than or 
                                                //  equal to 1?
                        limitIncrement *= -1;   //reinitialize limitIncrement with a flipped sign
                        spaceChar = "\b";       //reinitialize spaceChar to backspace... allows
                                                //  deletion of previously added space " " chars
                                                //  to space String
                    }//end if statement
                }//end for loop
                */ //REMOVE THIS LINE
                /*********************************************************************************
                 * End bowtie with for loop implementation ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                *********************************************************************************/
                
                /*********************************************************************************
                 * Begin bowtie with do-while loop implementation ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                *********************************************************************************/
                /* REMOVE THIS LINE
                //reinitialize significant variables to default settings
                spaceChar = " ";        //character to be added onto space String
                nStars = nStarsInput;   //max width of bowtie
                starsLimit = nStars;    //limit for the number of stars to be printed
                                        //  on the current line
                starCount = starsLimit; //number of stars to print
                limitIncrement = -2;    //how much starsLimit will be decremented
                                        //  or incremented by
                
                //>>>while loop below prints the appropriate number of space and "*"
                //    characters per line on each loop;
                //    top half of bowtie is printed before the condition starsLimit <= 1
                //    is met;
                //    bottom half of bowtie is printed after the condition starsLimt <= 1
                //    is met
                
                doLoopLine: //label for do-while loop below
                do  {   //loop forever until break encountered
                    if (starsLimit > nStars){   //starsLimit updated to a value greater
                                                //  than initial nStars input?
                        break doLoopLine;       //break out of while loop labeled loopLine
                    }//end if statement
                    
                    //>>>while loop below adds a "*" to String starLine on each loop;
                    //    starsLimit is incremented or decremented accordingly under the 
                    //    condition that there are no more stars to be added onto the 
                    //    current line;
                    //
                    doLoopStars:  //label for while loop below
                    while (true){   //loop forever until break encountered
                        if (starCount < 1){     //no more "*" characters left to add
                                                //  onto the current line to be printed?
                            starsLimit += limitIncrement;   //decrement or increment starsLimit
                                                            //  depending on current sign of
                                                            //  limitIncrement
                            starCount = starsLimit;         //reinitialize starCount to updated 
                                                            //  starsLimit
                            break doLoopStars;  //break out of while loop labeled doLoopStars
                        }//end if statement
                        starLine += starChar;   //add "*" onto current line to be printed
                        starCount--;            //decrement number of "*" characters left
                                                //  to add onto current line to be printed
                    }//end while loop labeled loopStars
                    System.out.printf("%s%s\n",space,starLine); //print space and starLine Strings
                    space += spaceChar;         //adds " " onto space String when printing top half
                                                //adds "\b" into space String when printing bottom
                    starLine = "";              //reset starLine String
                    if (starsLimit <= 1){       //starsLimit updated to a value less than or 
                                                //  equal to 1?
                        limitIncrement *= -1;   //reinitialize limitIncrement with a flipped sign
                        spaceChar = "\b";       //reinitialize spaceChar to backspace... allows
                                                //  deletion of previously added space " " chars
                                                //  to space String
                    }//end if statement
                } while (true); //end do-while loop labeled doLoopLine
                */ //REMOVE THIS LINE
                /*********************************************************************************
                 * End bowtie with do-while loop implementation ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                *********************************************************************************/
                
                //reinitialize significant variables to default settings
                spaceChar = " ";        //character to be added onto space String
                nStars = nStarsInput;   //max width of bowtie
                starsLimit = nStars;    //limit for the number of stars to be printed
                                        //  on the current line
                starCount = starsLimit; //number of stars to print
                limitIncrement = -2;    //how much starsLimit will be decremented
                                        //  or incremented by
            }//end if statement
            else {
                System.out.println("EXITED!");
                break continueLoop;
            }
        }//end while loop labeled continue
    }//end main method
}//end class