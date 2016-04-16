// Eddison Ugaddan
// April 15, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// Lab 11: Search program:
//  (1) fills an Integer array with random numbers, and finds 
//      the max/min values by linear search (selectionSort)
//  (2) fills another Integer array with increasing random numbers,
//      finds the max/min values by linear search (selectionSort),
//      requests for a search term from the user by way of Scanner,
//      and performs binary search to search for the search term in the 'chaotic' array

import java.util.Random;    
import java.util.Scanner;

public class Search{
    public static void main(String[] args){
        //initialize variables
        int size = 50;
        int[] array1 = new int[size];
        int[] sortedArray1 = new int[size];
        int[] array2 = new int[size];
        int searchTerm = 0;
        
        array1 = fillArray(size);   //fill array1 with random numbers
        sortedArray1 = selectionSort(array1);   //sort a copy of array1 in ascending order
        printBounds(sortedArray1, size, 1);     //print max/min values, given an 
                                                //  input array sorted in ascending order
        
        array2 = fillChaoticArray(size);    //fill array2 with increasing random numbers
        printBounds(array2, size, 2);       //print max/min values, given an
                                            //  input array sorted in ascending order
        //printArray(array2);       //for debugging
        searchTerm = promptInt();   //prompt user for a >= 0 search term Integer
        if (searchTerm > -1){       //search term is >= 0
            binarySearch(array2, searchTerm);   //call binarySearch method
        }//end if statement
    }//end main method
    
    //generate an array of randomly generated numbers
    public static int[] fillArray(int size){    
        //initialize local variables
        int[] array = new int[size];
        Random rand = new Random();
        
        for (int i = 0; i < size; i++){     //loop through each element in array
            array[i] = rand.nextInt(101);   //assign a new random number in range [0,100]
                                            //  to each slot in array
        }//end for loop
        return array;   //return filled array
    }//end fillArray
    
    //generate a copy of an inputted array
    public static int[] copyArray(int[] inArray){
        //initialize local variables
        int[] outArray = new int[inArray.length];
        
        for (int i = 0; i < inArray.length; i++){   //loop through each element in array
            outArray[i] = inArray[i];           //copy inArray to outArray
        }//end for loop
        return outArray;                        //return copied array
    }//end copyArray method
    
    //sort to ascending order the input Integer array
    public static int[] selectionSort(int[] inArray){
        //initialize local variables
        int[] outArray = copyArray(inArray);
        
        for (int i = 0; i < outArray.length-1; i++){
            for (int j = i+1; j < outArray.length; j++){
                if (outArray[j] < outArray[i]){ //integer in next position j is actually of lesser value
                                                //  than integer in current position i?
                    int p = outArray[i];        //temporarily store value at position i in placeholder variable p
                    outArray[i] = outArray[j];  //move lesser value located at j to position i
                    outArray[j] = p;            //move greater value stored in placeholder variable p to position j
                }//end if statement
            }//end inner for loop
        }//end outer for loop
        return outArray;   //return sorted array
    }//end selectionSort method
    
    //generate array with increasing random numbers
    public static int[] fillChaoticArray(int size){
        //initialize local variables
        int[] array = new int[size];
        Random rand = new Random();
        int lastNum = 0;
        
        for (int i = 0; i < size; i++){     //loop through each element in array
            lastNum += rand.nextInt(101);   //add a new random number to last generated number
            array[i] = lastNum;             //fill array with increasing random numbers
        }
        return array;                       //return array with increasing random numbers
    }//end fillChaoticArray method
    
    //print max/min values of an array
    public static void printBounds(int[] array, int size, int order){
        System.out.printf("MAX of array%d: %d\tMIN of array%d: %d\n", order, array[size-1], order, array[0]);
    }//end printBounds method
    
    //print an array
    public static void printArray(int[] array){
        for (int e = 0 ; e < array.length; e++){
            System.out.print(array[e] + " ");
        }
    }//initialize printArray method
    
    //request user to input >= 0 Integer
    public static int promptInt(){
        //initialize local variables
        Scanner sc;
        int input = 0;
        
        while (true){   //loop forever until break encountered
            System.out.print("Enter an int: ");
            sc = new Scanner(System.in);
            if (sc.hasNextInt()){       //first scanned token is an Integer?
                input = sc.nextInt();   //assign scanned Integer to variable 'input'
                if (input >= 0){    //input is in valid range 0 or greater?
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
    
    //perform binary search on input Integer array, searching for Integer 'term'
    public static void binarySearch(int[] array, int term){
        if (term > array[array.length-1] || term < array[0]){   //search term is outside max/min range of array2?
            System.out.println("Searched term is out of bounds!  Goodbye!");
        }//end if statement
        else {  //search term must be in valid range!
            int low = 0;
            int high = array.length-1;
            int mid = low + (high-low)/2;
            int breakIndex = 0;
            boolean found = false;
            
            while (low <= high && found == false){
                mid = low + (high-low)/2;   //update midpoint index
                if (term == array[mid]){    //search term already at midpoint?
                    System.out.printf("%d was located at index position %d\n", term, mid);
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
                    System.out.printf("%d was not found...\nNumber above: %d\nNumber below: %d\n", 
                        term, array[high+1], array[low-1]);
                }//end if statement
            }//end while loop
        }//end else statement
    }//end binarySearch method
}//end class