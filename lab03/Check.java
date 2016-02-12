// Eddison Ugaddan
// February 12, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// Lab 3: Check program takes in user input for the bill price, tip percentage desired, how
//  many ways the bill is to be split, and calculates the amount each person will be paying

import java.util.Scanner;   //import Scanner class for getting user input

public class Check{
    public static void main(String[] args){
        final Scanner scan = new Scanner(System.in);
        System.out.println("-------------------YOUR RECEIPT-------------------");
        System.out.print("Cost before tip: $");                             //request bill cost before tip
        double baseBill = scan.nextDouble();                                //read user input for double, assign to baseBill
        System.out.print("Desired tip percentage (whole number!): ");       //request tip percentage as a whole number
        double tipPerc = scan.nextInt()/100.0;                              //read user input for integer tip percent,
                                                                            //  divide by 100.0 to cast as double and convert 
                                                                            //  to decimal equivalent
        double totalBillActual = baseBill * (1+tipPerc);                    //calculate total bill
       
        double totalBillDisplay = truncateToTwoDecimals(totalBillActual);   //truncate total bill to a human-friendly 
                                                                            //  currency value
        
        System.out.print("Split the total of $" + totalBillDisplay +        //request how many ways bill will be split
            " (approximate value) between how many people: ");
        int splitNum = scan.nextInt();                                      //read user input for integer number of ways bill
                                                                            //  will be split
        
        double splitBillActual = totalBillActual/splitNum;                  //calculate individual amount to pay
        double splitBillDisplay = truncateToTwoDecimals(splitBillActual);   //truncate individual amount to a 
                                                                            //  human-friendly currency value
        double adjustedSplitBillDisplay = truncateToTwoDecimals(splitBillDisplay + 0.01);   //adjust for truncation, add one cent
        System.out.println("EACH PERSON PAYS: $" + adjustedSplitBillDisplay +   //give final individual amount each person pays
            "\n-----------THANK YOU!  HAVE A NICE DAY!-----------");
            
    }//end main method
    
    //following method takes in one input of a double, and outputs a double
    //   the method truncates the input double down to two decimal places, which it outputs
    public static double truncateToTwoDecimals(double reallyLongDecimal){
       reallyLongDecimal *= 100;                        //multiply long decimal by 100
       int truncatedDecimal = (int)reallyLongDecimal;   //explicitly cast double to int, 
                                                        //  truncate (chop off) all decimals,
                                                        //  leaving an integer
       double shortDecimal = truncatedDecimal;          //implicitly cast int to double,
       shortDecimal /= 100;                             //  and divide truncated decimal by 100,
                                                        //  leaving a number with two decimal places
       return shortDecimal;                             //output the original decimal
                                                        //  truncated to two decimal places
                                                        //  *two places to represent currency 
                                                        //  e.g. $1.99
    } // end truncateToTwoDecimals method
}//end class