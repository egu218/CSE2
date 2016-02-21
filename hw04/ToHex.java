// Eddison Ugaddan
// February 21, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW04: ToHex program receives user input of three decimal values in range [0,255], 
//  representing RGB pixel intensity values, to be converted to their corresponding
//  hexadecimal equivalent, and printed out

// NOTE: I referred to Oracle's Java API and Stack Overflow forums (reading previously asked
//  and answered questions) to figure out things such as splitting a String, parsing
//  String to Integer, using the Array .length property, 

import java.util.Scanner;   //import Scanner class for getting user input

public class ToHex{
    public static void main(String[] args) {
        final Scanner scan = new Scanner(System.in);    //initialize Scanner Object
        
        String rgbInput = "";                       //initialize String variable for holding raw user input
        String[] rgbInputSplit = new String[0];     //initialize String Array for holding the separate 
                                                    //  String Objects created when user input is 
                                                    //  split at each space ' '
        Scanner scanSplitVal;                       //initialize Scanner Object, later corresponding 
                                                    //  with each String Object in rgbInputSplit String Array
        int[] decValues = new int[3];               //initialize empty Integer Array of size 3 
                                                    //  (i.e. [0 0 0])
        String errorNotice = "Oh dear!  Error(s) encountered:"; //initialize errorNotice 
        
        System.out.println("Please enter three whole number RGB values" +   //print request for
            "\n(Must be in range [0,255] e.g.: >> 192 255 238");             //  input from user
           
        //>>>the following until the next '>>>' comment filters out invalid input
        boolean validInput = false;             //initialize boolean validInput for use in 
                                                //  while-loop re-loop
        while (validInput == false) {
            validInput = true;                  //set validInput boolean to true so that when 
                                                //  an invalid input is encountered, 
                                                //  validInput can be set to false,
                                                //  leading to a re-loop of the while-loop;
                                                //  on the contrary when no invalid input is
                                                //  encountered, then the while-loop 
                                                //  simply runs once
            System.out.print(">> "); 
            rgbInput = scan.nextLine();                 //request user input, and 
                                                        //  assign input to variable rgbInput
       
            if (rgbInput.length() <= 11) {  //check for valid input String length 
                                            //  = 2 spaces + maximum 3 digits * 3 values = 11
                rgbInputSplit = rgbInput.split("\\s+");   //split input string at each
                                                        //  space/consecutive string of spaces
                                                        //  into String objects, 
                                                        //  and use to fill String Array
                                                        //  called rgbInputSplit
                //in for-loop below: fill Integer array of decValues using 
                //  String-to-Integer parsed values contained in rgbInputSplit String Array
                for (int i = 0; i < rgbInputSplit.length; i++) {
                    scanSplitVal = new Scanner(rgbInputSplit[i]);   //initialize a Scanner
                                                                    //  Object for each
                                                                    //  String Object
                                                                    //  contained in 
                                                                    //  rgbInputSplit Array
                    if (!scanSplitVal.hasNextInt()) {   //check that the Scanner Object 
                                                        //  scanSplitVal has no Integer
                        
                        errorNotice += "\n\t\t+ (input" + (i+1) + ") input can only have integers";
                        //System.out.println("Oh dear!  Your input can only have integers!" +
                        //    "\n(Must be in range [0,255] e.g.: >> 244 29 178");
                        validInput = false;             //invalid input encountered,
                                                        //  so set validInput boolean to false
                                                        //  to allow re-loop
                    }
                    else {                              //otherwise scanSplitVal does have an Integer
                        decValues[i] = Integer.parseInt(rgbInputSplit[i]);  //fill decValues Integer Array
                                                                            //  using String-to-Integer
                                                                            //  parsed values from
                                                                            //  rgbInputSplit String Array
                        if (decValues[i] < 0 || decValues[i] > 255) {   //check that each RGB decimal value
                                                                        //  is outside the valid range [0,255]
                            errorNotice += "\n\t\t+ (input" + (i+1) + ") input must be in range [0,255] inclusive";
                            validInput = false;         //invalid input encountered,
                                                        //  so set validInput boolean to false
                                                        //  to allow re-loop
                        }
                    }
                }
            }
            else {      //input String length !<= 11 characters long
                errorNotice += "\n\t\t+ input is too long";
                validInput = false;     //invalid input encountered, so 
                                        //  set validInput boolean to false to allow re-loop
            }
            
            if (rgbInputSplit.length != 3) {        //check for failure of the original input String
                                                    //  to split into three values i.e. size
                                                    //  of rgbInputSplit String Array is 3
                errorNotice += "\n\t\t+ missing three integers";
                validInput = false;     //invalid input encountered, so 
                                        //  set validInput boolean to false to allow re-loop
            }
            
            if (validInput == false) {  //if any invalid input was encountered, do the following:
                System.out.println(errorNotice + "\nInvalid input; try again!" +
                    "\n(Must be in range [0,255] e.g.: >> 192 255 238");
            }
            errorNotice = "Oh dear!  Error(s) encountered:";    //reinitialize errorNotice for re-loop
        }
        
        //>>>the following converts the validated Integer Array of rgb decimal values 
        //  to their hexadecimal counterpart
        //for-loop below loops through each Integer Object (red, green, and blue values individually),
        //  calculates their corresponding hexadecimal value, and assigns the hexadecimal values to 
        //  a String Array
        int leadDecVal;         //initialize Integer variable to hold 'lead' decimal value after division
        int trailDecVal;        //initialize Integer variable to hold 'trail' remaining decimal value after division
        String hexLead = "";    //initialize String variable to hold 'lead' hexadecimal value after conversion
        String hexTrail = "";   //initialize String variable to hold 'trail' hexadecimal value after conversion
        String[] hexValues = new String[3]; //initialize String Array of size 3 to hold hexadecimal values
        for (int j = 0; j <= 2; j++) {
            leadDecVal = (decValues[j]/16);       //find how many times 16 fits into the given
                                                  //  value at current index position j in
                                                  //  decValues Integer Array, and truncate
                                                  //  any trailing decimals
            trailDecVal = (decValues[j]%16);      //find the remainder left after dividing by 16
                                                  //  the value at current index position j in
                                                  //  decValues Integer Array
            hexLead = toHex(leadDecVal, true);    //call toHex method to convert inputted 
                                                  //  'lead' decimal value to hexadecimal
            hexTrail = toHex(trailDecVal, false); //call toHex method to convert inputted 
                                                  //  'trail' decimal value to hexadecimal
            hexValues[j] = "" + hexLead + hexTrail; //assign hexadecimal String values to 
                                                    //  hexValues String Array 
        }
        System.out.printf("Given decimal values R:%d G:%d B:%d -\nThe corresponding" +      //final 
            " hexadecimal values are %s%s%s\n", decValues[0], decValues[1], decValues[2],   //  print
            hexValues[0], hexValues[1], hexValues[2]);                                      //  statement!
    }//end main method
    
    //following method, given a decimal value [0,15], outputs it's corresponding 
    //  hexadecimal value as a String Object
    public static String toHex(int decVal, boolean leadVal) {
        String hexVal = "";
        switch (decVal) {
            case 10:    //if decVal == 10
                hexVal = "A";
                break;  
            case 11:    //if decVal == 11
                hexVal = "B";
                break;  
            case 12:    //if decVal == 12
                hexVal = "C";
                break;  
            case 13:    //if decVal == 13
                hexVal = "D";
                break;  
            case 14:    //if decVal == 14
                hexVal = "E";
                break;  
            case 15:    //if decVal == 15
                hexVal = "F";
                break;
            default:    //default case is decVal == [0,9] which means 
                        //  the same for either decimal or hexadecimal
                hexVal += decVal;
                break;
        }
        return hexVal;  //output hexadecimal value corresponding with inputted decimal value
    }//end toHex method
}//end class