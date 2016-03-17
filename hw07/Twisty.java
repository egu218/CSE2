// Eddison Ugaddan
// March 17, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW07: Twisty program takes in user input of two integers: twist length which
//  must be in range [1,80], and twist width which must be in range [1,length];
//  Line by line a helix pattern consisting of '#', '/', and '\' characters
//  is printed - spanning a horizontal length set by the inputted twist length,
//  and a vertical width set by the inputted twist width

import java.util.Scanner;   //import Scanner class for getting user input

public class Twisty{
    public static void main(String[] args){
        //initialize variables used for validating user input
        Scanner scan;
        String requestLength;
        String requestWidth;
        String errorIntMsg;
        String errorLengthMsg;
        String errorWidthMsg;
        boolean validLength;
        boolean validWidth;
        int twistLength;
        int twistWidth;
        
        requestLength = "Desired twist length: ";
        requestWidth = "Desired twist width: ";
        errorIntMsg = "\tError: input must be an Integer!  Try again.";
        errorLengthMsg = "\tError: length must be in range [1,80]!  Try again.";
        errorWidthMsg = "\tError: width must be in range [1,length]!  Try again.";
        validLength = false;
        validWidth = false;
        twistLength = 0;
        twistWidth = 0;
        
        //>>>while loop below validates user input for twist length
        while (!validLength){   //run while validLength is false - break when true
            System.out.print(requestLength);    //request 
            scan = new Scanner(System.in);      //  user input
            if (scan.hasNextInt()){     //first token is an Integer?
                twistLength = scan.nextInt();   //assign first encountered Integer
                                                //  to twistLength variable
                if (twistLength > 0 && twistLength <= 80){  //twistLength is in range?
                    validLength = true; //valid input for twistLength found,
                                        //  allow exit out of this while loop
                }//end if statement
                else {  //error encountered!
                    System.out.println(errorLengthMsg);
                }//end else statement
                
            }//end if statement
            else {      //error encountered!
                System.out.println(errorIntMsg);
            }//end else statement
        }//end while loop
        
        //>>>while loop below validates user input for twist width
        while (!validWidth){   //run while validWidth is false - break when true
            System.out.print(requestWidth);     //request 
            scan = new Scanner(System.in);      //  user input
            if (scan.hasNextInt()){     //first token is an Integer?
                twistWidth = scan.nextInt();    //assign first encountered Integer
                                                //  to twistWidth variable
                if (twistWidth > 0 && twistWidth <= twistLength){  //twistWidth is in range?
                    validWidth = true;  //valid input for twistLength found,
                                        //  allow exit out of this while loop
                }//end if statement
                else {  //error encountered!
                    System.out.println(errorWidthMsg);
                }//end else statement
                
            }//end if statement
            else {      //error encountered!
                System.out.println(errorIntMsg);
            }//end else statement
        }//end while loop
        
        //initialize variables used for printing lines of twist
        String twistChar1;
        String twistChar2;
        String twistChar3;
        String twistChar;       
        String skipChar;
        String twistLine;
        int xType;
        int xStart;
        int xEnd;
        int indexInBlock;
        int indexInLine;
        int lineCount;
        
        twistChar1 = "#";
        twistChar2 = "/";
        twistChar3 = "\\";
        twistChar = "#";
        skipChar = " ";
        twistLine = "";
        xType = 0;
        xStart = 1;
        xEnd = twistWidth;
        indexInBlock = 1;
        indexInLine = 1;
        lineCount = 0;
        
        //>>>while loop below prints lines of twist,
        //  and reinitializes the appropriate variables to allow the nested 
        //  while loop to build the next line properly
        loopLine:
        while (true){
            //>>>while loop below builds a new line of twist
            loopChar:
            while (true){
                //if and else statements below determine what 
                //  character to be added onto twistLine
                //when twistWidth is odd, xStart increments and xEnd decrements
                //  such that at one point they share the same position...
                //  in this case the xStart if statement is placed after
                //  the xEnd if statement to allow overwriting of the
                //  twistChar determined by the xEnd if statement
                //when twistWidth is even, xStart never shares the same position
                //  with xEnd
                if (indexInBlock == xEnd){  //index position in this block
                                            //  is at position of ending char?
                    if (xType == 0){    //inside 1st type of 'X'?
                        twistChar = twistChar2;     //char to be added is '/'
                    }
                    else {              //must be inside 2nd type of 'X'!
                        twistChar = twistChar1;     //char to be added is '#'
                    }
                }//end if statement
                if (indexInBlock == xStart){//index position in this block
                                            //  is at position of starting char?
                    if (xType == 0){    //inside 1st type of 'X'?
                        twistChar = twistChar1;     //char to be added is '#'
                    }
                    else {              //must be inside 2nd type of 'X'!
                        twistChar = twistChar3;     //char to be added is '\'
                    }
                }//end if statement
                //if neither at starting nor ending char position, 
                //  then must be whitespace!
                if (indexInBlock != xStart && indexInBlock != xEnd){
                    twistChar = skipChar;           //char to be added is ' '
                }//end if statement
                
                //if and else statements below signal what type of 'X' the 
                //  indexInLine is in;
                if ((indexInLine / twistWidth)%2 == 0)
                {
                    xType = 0;                      //1st type of 'X'
                }//end if statement
                else {
                    xType = 1;                      //2nd type of 'X'
                }//end else statement
                
                twistLine += twistChar; //add twistChar onto twistLine String
                indexInBlock++;         //move up one index position in current block
                indexInLine++;          //move up one index position in this line
                
                //if statements below act as index reset switches and 
                //  allow break out of loop
                if (indexInBlock > twistWidth){ //index position in current block 
                                                //  has passed end of block?
                    indexInBlock = 1;   //reset index within block
                }//end if statement
                if (indexInLine > twistLength){ //expected number of chars reached 
                                                //  for this line?
                    break loopChar;     //break out of while loop labeled loopChar
                }//end if statement
            }//end while loop labeled loopChar
            
            System.out.printf("%s\n",twistLine);    //print latest line of twist!
            lineCount++;        //increment number of lines printed
            
            twistLine = "";     //reset twistLine variable
            xType = 0;          //reset xType variable; set first block of 
                                //  next line to be 1st type of 'X'
            indexInBlock = 1;   //reset index within block
            indexInLine = 1;    //reset index within line                    
            xStart++;           //increment index position of starting char
            xEnd--;             //decrement index position of ending char
            
            if (lineCount >= twistWidth){   //printed all the lines of twist?
                break loopLine;         //break out of while loop labeled loopLine
            }
        }//end while loop labeled loopLine
    }//end main method
}//end class