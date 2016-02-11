// Eddison Ugaddan
// February 11, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW03: Pyramid program takes in user inputs of doubles representing measurements of a pyramid,
//  the side of a square base, and the height, and prints out the calculated volume

import java.util.Scanner;       //import Scanner class for getting user input

public class Pyramid{
    public static void main(String[] args){     //main method
        
        
        Scanner sc = new Scanner(System.in);    //initialize Scanner object
        
        System.out.print("Feed me the length of " +     //request user input for edge length
            "one side of the square base: ");
        double inputEdge = sc.nextDouble();         //assign user inputted edge length into 
                                                    //  double variable inputEdge
        System.out.print("I'm still hungry... " +
            "feed me the pyramid's height: ");      //request user input for pyramid height
        double inputHeight = sc.nextDouble();       //assign user inputted pyramid height into
                                                    //  double variable inputHeight
        
        double volume = Math.pow(inputEdge,2)*inputHeight/3;      //calculate volume of a square base pyramid
        
        System.out.println("The square pyramid's volume = " +   //print the calculated volume
            volume + " cube units!");
        
        
    } //end main method
} //end class