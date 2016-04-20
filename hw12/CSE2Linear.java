// Eddison Ugaddan
// April 20, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW12: Linear program:
//  (1) fills a sorted array consisting of grades inputted in ascending order from user,
//      and by binary (instead of linear) search tries to find the search term also provided by the user
//  (2) scrambles the sorted array in (1),
//      and by linear search tries to find the search term again provided by the user

import java.util.Scanner;
import java.util.Random;

public class CSE2Linear{
    public static void main(String[] args){
        int size = 15;
        int[] sortedGrades = new int[size];
        int[] scrambledGrades = new int[size];
        
        sortedGrades = promptGrades(size);
        System.out.println("Sorted:");
        printArray(sortedGrades);
        binarySearch(sortedGrades, promptInt());
        
        scrambledGrades = scrambleArray(copyArray(sortedGrades), 3); //scramble a copy of 
                                                                     //  sortedGrades 3 times
        System.out.println("Scrambled:");
        printArray(scrambledGrades);
        linearSearch(scrambledGrades, promptInt(), false);
    }//end main method
    
    public static int[] promptGrades(int size){
        Scanner sc;
        int[] grades = new int[size];
        int previous = 0;
        int input = 0;
        int index = 0;
        
        System.out.printf("Input %d grades: ", size);
        sc = new Scanner(System.in);
        
        while (index < size){  //loop until index increments to size
            if (sc.hasNextInt()){       //next token is an Integer?
                input = sc.nextInt();   //assign input as next Integer 
                if (input >= 0 && input <= 100 && input >= previous){    //input is in valid range?
                        grades[index] = input;  //fill element at current index with valid input
                        index++;            //increment index   
                        previous = input;   //update previous term
                }//end if statement
                else {  //input must be out of range!
                    if (input < 0 || input > 100){      //invalid range error?
                        System.out.printf("An inputted grade(s) is out of range, try again!"
                        + "\n\t%d more grades to input: ", (size-index));
                        sc = new Scanner(System.in);    //reinitialize Scanner
                    }//end if statement
                    else {  //next token encountered must be of lesser value than previous term!
                        System.out.printf("An inputted grade(s) was not greater or equal"
                            + " to the grade of %d, try again!"
                            + "\n\t%d more grades to input: ", previous, (size-index));
                        sc = new Scanner(System.in);    //reinitialize Scanner
                    }//end else statement
                }//end else statement
            }//end if statement
            else {                  //next token must be a non-Integer!
                System.out.printf("Input is not an Integer, try again!"
                    + "\n\t%d more grades to input: ", (size-index));
                sc = new Scanner(System.in);        //reinitialize Scanner
            }//end else statement
        }//end while loop
        return grades;
    }//end promptGrades method
    
    //print an array
    public static void printArray(int[] array){
        for (int e = 0 ; e < array.length; e++){
            System.out.print(array[e] + " ");
        }
        System.out.println();
    }//initialize printArray method
    
    //request user to input >= 0 Integer
    public static int promptInt(){
        //initialize local variables
        Scanner sc;
        int input = 0;
        
        while (true){   //loop forever until break encountered
            System.out.print("Enter an grade to search for: ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()){       //first scanned token is an Integer?
                input = sc.nextInt();   //assign scanned Integer to variable 'input'
                if (input >= 0 && input <= 100){    //input is in valid range 0 or greater?
                    break;  //break out of while loop
                }//end else statement
                else {  //must be outside desired range of values!
                    System.out.println("Not an integer 0 or greater, try again!");
                }//end else statement
            }//end if statement
            else {      //first token scanned must be non-integer!
                System.out.println("Not an integer; exiting!");
                input = -1;
                break;  //break out of while loop
            }//end else statement
        }//end while loop
        return input;
    }//end promptInt method
    
    public static void binarySearch(int[] array, int term){
        int iterations = 0;
        if (term > array[array.length-1] || term < array[0]){   //search term is outside max/min range of array2?
            iterations++;
            System.out.println("\tSearched term is out of bounds!  Goodbye!"
                + "\n" + term + " not found after " + iterations + " iterations");
        }//end if statement
        else {  //search term must be in valid range!
            int low = 0;
            int high = array.length-1;
            boolean found = false;
            
            while (low <= high && found == false){
                int mid = low + (high-low)/2;   //update midpoint index
                iterations++;
                if (term == array[mid]){    //search term already at midpoint?
                    System.out.printf("\t%d was located after %d iterations\n", term, iterations);
                    found = true;
                }
                else if (term > array[mid]){//search term of value greater than that at midpoint?
                    //System.out.printf("\n%d %d %d", array[low], array[mid], array[high]); //for debugging
                    low = mid+1;            //update low index
                }
                else {  //search term must be of value less than that at midpoint!
                    //System.out.printf("\n%d %d %d", array[low], array[mid], array[high]); //for debugging
                    high = mid-1;           //update high index
                }//end else statement
                if (low > high){
                    System.out.printf("\t%d was not found...after %d iterations\n", term, iterations);
                }//end if statement
            }//end while loop
        }//end else statement
    }//end binarySearch method
    
    //search forwards through input array for search term
    public static void linearSearch(int[] array, int term, boolean sorted){
        for (int i = 0; i < array.length; i++){ //loop through each element in array
            if (term == array[i]){      //search term found!
                System.out.printf("Grade %d found after %d iterations\n", term, (i+1));
                break;  //break out of for loop
            }//end if statement
            if (array[i] > term && sorted == true){ //current member being evaluated is of greater
                                                    //  value than target term, in a sorted list?
                System.out.printf("Grade %d not found after %d iterations...\n", term, (i+1));
                break;  //break out of for loop
            }//end if statement
            if (i >= array.length-1){  //reached end of array without encountering target term
                System.out.printf("Grade %d not found after %d iterations...\n", term, (i+1));
            }//end if statement
        }//end for loop
    }//end linearSearch method
    
    //generate a copy of an inputted array
    public static int[] copyArray(int[] inArray){
        //initialize local variables
        int[] outArray = new int[inArray.length];
        
        for (int i = 0; i < inArray.length; i++){   //loop through each element in array
            outArray[i] = inArray[i];           //copy inArray to outArray
        }//end for loop
        return outArray;                        //return copied array
    }//end copyArray method
    
    //scramble the inputted array some number of times
    public static int[] scrambleArray(int[] array, int cycles){
        //initialize local variables
        Random rand = new Random();
        
        for (int n = 0; n < cycles; n++){   //scramble n many times
            for (int i = 0; i < array.length; i++){
                int randNum = rand.nextInt(array.length-1);   //generate a random number [0,14]
                int p = array[randNum];     //temporarily hold value at randomly generated 
                                            //  index position in a variable
                array[randNum] = array[i];  //move value at current index to generated index
                array[i] = p;               //move value held in placeholder variable to current index
            }//end inner for loop
            //printArray(array);    //for debugging
        }//end outer for loop
        return array;                       //return scrambled array
    }//end scrambleArray method
}//end class

