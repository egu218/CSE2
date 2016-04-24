// Eddison Ugaddan
// April 22, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// Lab 12: RaggedArray program:
//  (1) prompts user for size of main array
//  (2) constructs an empty 2D array of a size as designated by user in (1)
//  (3) initializes each member array with a randomly generated size in range [1,mainSize]
//  (4) prints the unsorted ragged array
//  (5) sorts values of each member array into ascending order
//  (6) prints the sorted ragged array
//  (7) sorts the 2D array by increasing lengths of the contained member arrays
//  (8) prints the row-sorted/rearranged ragged array
//  (9) prompts user for an Integer to search for
//  (10) linearly searches the 2D array for the first occurence of the user inputted target value
//      and prints the column and row representing its position; otherwise the value was not found

import java.util.Scanner;
import java.util.Random;

public class RaggedArray{
    public static void main(String[] args){
        Random rand = new Random();
        
        int mainSize = promptMainSize();
        int[][] multiArray = new int[mainSize][];
        for (int n = 0; n < multiArray.length; n++){
            int randSize = rand.nextInt(mainSize)+1;
            int[] memberArray = new int[randSize];  //generate member array of random size
                                                    //  in range [0,mainSize-1]
            multiArray[n] = memberArray;            //assign generated member array
                                                    //  to current index of 2D array
        }//end for loop
        
        for (int k = 0; k < multiArray.length; k++){
            for (int l = 0; l < multiArray[k].length; l++){
                multiArray[k][l] = rand.nextInt(21);//assign each element of current member array
                                                    //  a random value [0,20]
            }//end inner for loop
        }//end outer for loop
        
        System.out.println("\nUnsorted Ragged Array");
        printMultiArray(multiArray);                //print 2D array
        
        System.out.println("\nSorted Ragged Array");
        for (int o = 0; o < multiArray.length; o++){
            selectionSort(multiArray[o]);           //sort values of each member array 
                                                    //  within main 2D array
        }//end for loop
        printMultiArray(multiArray);                //print 2D array
        
        System.out.println("\nRow-sorted Ragged Array");
        selectionSort(multiArray);                  //sort 2D array by lengths of 
                                                    //  contained member arrays
        printMultiArray(multiArray);                //print 2D array
        
        System.out.println();
        firstOccurenceOf(multiArray, promptInt());  //print position of first occurence of 
                                                    //  user inputted target value within multiArray
        
    }//end main method
    
    //request for size of main array
    public static int promptMainSize(){
        Scanner sc;
        int mainSize = 1;
        while (true){
            System.out.print("Size of main array: ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()){   //next token is an Integer?
                mainSize = sc.nextInt();
                if (mainSize > 1){  //inputted size is greater than 0?
                    break;          //break while loop with valid mainSize
                }//end if statement
                else {              //inputted size must be less than or equal to 0!
                    if (mainSize == 1){
                        System.out.println("\tSize of 1 is not a 2D array!");
                    }//end if statement
                    else {
                        System.out.println("\tSize must be positive!");    
                    }//end else statement
                }//end else statement
            }//end if statement
            else {                  //next token must be a non-Integer!
                System.out.println("\tType an Integer for size of main array!");
            }//end else statement
        }//end while loop
        return mainSize;
    }//end promptMainSize method
    
    //print out the 2D array
    public static void printMultiArray(int[][] multiArray){
        for (int i = 0; i < multiArray.length; i++){
            for (int j = 0; j < multiArray[i].length; j++){
                System.out.print(multiArray[i][j] + " ");
            }//end inner for loop
            System.out.println();
        }//end outer for loop
    }//end printArray
    
    //sort to ascending order the input Integer array
    public static void selectionSort(int[] inArray){
        for (int i = 0; i < inArray.length-1; i++){
            for (int j = i+1; j < inArray.length; j++){
                if (inArray[j] < inArray[i]){   //integer in next position j is actually of lesser value
                                                //  than integer in current position i?
                    int p = inArray[i];         //temporarily store value at position i in placeholder variable p
                    inArray[i] = inArray[j];    //move lesser value located at j to position i
                    inArray[j] = p;             //move greater value stored in placeholder variable p to position j
                }//end if statement
            }//end inner for loop
        }//end outer for loop
    }//end selectionSort method
    
    //sort to ascending order the input ragged Integer array
     public static void selectionSort(int[][] multiArray){
        for (int i = 0; i < multiArray.length-1; i++){
            for (int j = i+1; j < multiArray.length; j++){
                if (multiArray[j].length < multiArray[i].length){   //length of next member array at position j 
                                                                    //  is actually shorter than length of current 
                                                                    //  member array at position i?
                    int[] p = multiArray[i];        //temporarily store array at position i in placeholder variable p
                    multiArray[i] = multiArray[j];  //move shorter member array located at j to position i
                    multiArray[j] = p;             //move longer member array stored in placeholder variable p to position j
                }//end if statement
            }//end inner for loop
        }//end outer for loop
    }//end selectionSort method
    
    //request positive Integer input from user
    public static int promptInt(){
        //initialize local variables
        Scanner sc;
        int input = 0;
        
        while (true){                   //loop forever until break encountered
            System.out.print("Number to search for: ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()){       //first scanned token is an Integer?
                input = sc.nextInt();   //assign scanned Integer to variable 'input'
                if (input >= 0){        //input is in valid range 0 or greater?
                    break;              //break out of while loop
                }//end else statement
                else {                  //must be outside desired range of values!
                    System.out.println("Not an integer 0 or greater, try again!");
                }//end else statement
            }//end if statement
            else {                      //first token scanned must be non-integer!
                System.out.println("Not an integer; exiting!");
                input = -1;
                break;                  //break out of while loop
            }//end else statement
        }//end while loop
        return input;
    }//end promptInt method
    
    //search for first occurence of target value in the 2D array
    public static void firstOccurenceOf(int[][] multiArray, int target){
        boolean found = false;
        loopOuter:
        for (int x = 0; x < multiArray.length; x++){
            for (int y = 0; y < multiArray[x].length; y++){
                if (multiArray[x][y] == target){    //value at current index in current member array
                                                    //  matches target value?
                    System.out.printf("Column %d Row %d\n", y+1, x+1);
                    found = true;                   //flag target as being found
                    break loopOuter;                //break out of entire nested for loops
                }//end if statement
            }//end inner for loop
        }//end outer for loop
        if (found != true){ //target not flagged as found after searching?
            System.out.println("Not in the array!");
        }
    }//end firstOccurenceOf method
}//end class