// Eddison Ugaddan
// February 11, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW03: Convert program takes in user inputs of integers representing a unit (meters), 
//  calculates the equivalent in another unit (inches), and prints out the result

import java.util.Scanner;       //import Scanner class for getting user input

public class Convert{
    public static void main(String[] args){     //main method
        final double meterToInch = 39.3701;     //constant meter:inch ratio
        Scanner sc = new Scanner(System.in);    //initialize Scanner object
        
        System.out.print("Convert meters to inches (enter meters): ");  //request user input for meters
        int inputMeter = sc.nextInt();  //assign integer found in user input to integer variable inputMeter
        System.out.println(inputMeter + " meters = " + inputMeter*meterToInch + " inches!");    //print the converted number
        
        
    } //end main method
} //end class