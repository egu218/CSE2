// Eddison Ugaddan
// March 29, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW09: Rectangularize program

import java.util.Scanner;

public class Rectangularize{
    public static void main(String[] args){
        //initialize variables
        Scanner sc;
        String rules;
        String rqstInput;
        String inputString;
        String exitMsg;
        String stringErrorMsg;
        String inputErrorMsg;
        int inputNum;
        
        rules = "\tEnter either an integer, or a string of alphabet-only letters!" +
            "\n\t(Enter '.' at any time to EXIT to main menu.)";
        rqstInput = "Please enter an input: ";
        exitMsg = "Thank you for trying Rectangularize!  Goodbye!";
        inputErrorMsg = "Need either an integer or a string of alphabet letters!";
        
        System.out.println(rules);              //print rules
        while (true){                           //run forever until break encountered
            System.out.print(rqstInput);        //print request for user input
            sc = new Scanner(System.in);        //read user input
            if (sc.hasNextInt()){               //next token is integer?
                inputNum = sc.nextInt();        //get input integer from next token found
                rectangularize(inputNum);       //call rectangularize(int) method
            }//end if statement
            else if (sc.hasNext()){             //next token is non-integer?
                inputString = sc.next();        //get input string from next token found
                if (inputString.equalsIgnoreCase(".")){ //user inputted '.'?
                    System.out.println(exitMsg);        //print exit message
                    break;                      //break out of this while loop
                }//end if statement
                
                int length = inputString.length();  //get length of input string
                boolean validString = true;     //assume valid input string as default
                //loop through each character in inputted string
                for (int i = 0; i < length; i++){   
                    //input string contains non-alphabet characters?
                    if (!Character.isAlphabetic(inputString.charAt(i))){ 
                        validString = false;    //flag input string is invalid
                        break;  //break out of this for loop
                    }//end if statement
                }//end for loop
                if (!validString){  //input string is not alphabet-only?
                    System.out.println(inputErrorMsg); //print input error message
                }//end if statement
                else {              //must be valid string!
                    rectangularize(inputString);    //call rectangularize(String) method
                }//end else statement
            }//end else if statement
            else {  //non-integer and non-alphabet!
                System.out.println(inputErrorMsg);  //print input error message
            }//end else statement
        }//end while loop
    }//end main method
    
    public static void rectangularize(String inString){
        //initialize local variables
        String output;
        int length;
        
        output = "";
        length = inString.length();
        
        for (int n = 0; n < length; n++){   //loop as long as n is less than
                                            //  input String's length
            output += "\n\n" + inString;    //add two new lines and the 
                                            //  inputted String to output
        }//end for loop
        System.out.println(output);         //print final output
    }//end rectangularize(String) method
    
    public static void rectangularize(int inNum){
        //initialize local variables
        String modChar;
        String output;
        String line;
        
        modChar = "%";
        output = "";    
        
        for (int i = 0; i < inNum; i++){    //loop as long as i is less than 
                                            //  inputted number
            line = "\n";                    //reinitialize new empty line
            for (int j = 0; j < inNum; j++){//loop as long as j is less than 
                                            //  inputted number
                line += modChar;            //append a modulus char to the line
            }//end for loop
            output += line;                 //add the last built line to output 
        }//end for loop
        System.out.println(output);         //print final output
        
    }//end rectangularize(int) method
}//end class
