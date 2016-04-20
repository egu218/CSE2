// Eddison Ugaddan
// April 19, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW12: RemoveElements program: 
//  (1) generates a randomized Integer array of size 10
//  (2) via delete() method deletes the entry at the specified position, and returns 
//      an updated array with appropriate size
//  (3) via remove() method deletes all instances of the target Integer within the
//      inputted array, and returns an updated array with appropriate size

import java.util.Scanner;
import java.util.Random;

public class RemoveElements{
    public static void main(String [] arg){
	    Scanner scan=new Scanner(System.in);
        int num[]=new int[10];
        int newArray1[];
        int newArray2[];
        int index,target;
    	String answer="";
    	do{
          	System.out.print("Random input 10 ints [0-9]");
          	num = randomInput();        //assign array 'num' a randomly generated array of size 10
          	String out = "The original array is:";
          	out += listArray(num);
          	System.out.println(out);
         
          	System.out.print("Enter the index ");
          	index = scan.nextInt();
          	newArray1 = delete(num,index);
          	String out1="The output array is ";
          	out1+=listArray(newArray1); //return a string of the form "{2, 3, -9}"  
          	System.out.println(out1);
         
            System.out.print("Enter the target value ");
          	target = scan.nextInt();
          	newArray2 = remove(num,target);
          	String out2="The output array is ";
          	out2+=listArray(newArray2); //return a string of the form "{2, 3, -9}"  
          	System.out.println(out2);
          	 
          	System.out.print("Go again? Enter 'y' or 'Y', anything else to quit-");
          	answer=scan.next();
    	}while(answer.equals("Y") || answer.equals("y"));
  }//end main method
    
    //list members of the inputted array
    public static String listArray(int num[]){
        String out="{";
    	for(int j=0;j<num.length;j++){
      	    if(j>0){
        	    out+=", ";
      	    }
      	    out+=num[j];
    	}
    	out+="} ";
    	return out;
    }//end listArray method
    
    //generate a random array
    public static int[] randomInput(){
        Random rand = new Random();
        int size = 10;
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++){
            int element = rand.nextInt(10); //generate random number [0,9]
            array[i] = element;             //fill array
        }//end for loop
        return array;                       //return randomly generated array of size 10
    }//end randomInput method
    
    //delete the entry at the specified position
    public static int[] delete(int[] list, int pos){
        int[] newArray = new int[list.length-1];
        int offSet = 0;
        for (int i = 0; i < newArray.length; i++){
            if (i >= pos){      //current index is at target position?
                offSet = 1;            //allow skip over member located at defined position
            }//end if statement
            newArray[i] = list[i+offSet];  //fill new array
        }//end for loop
        return newArray;    //return new array 
    }//end delete method
    
    //remove all instances of target match with element in list
    public static int[] remove(int[] list, int target){
        int count = 0;
        for (int i = 0; i < list.length; i++){
            if (list[i] == target){     //list member at current index matches target value?
                count++;        //increment number of target value matches in this array
            }//end if statement
        }//end for loop
        
        int[] newArray = new int[list.length-count];    //initialize new array of appropriate size
        int offSet = 0;
        int k = 0;
        for (int j = 0; j < list.length; j++){
            if (k >= newArray.length){ //newArray has been filled?
                break;
            }
            if (list[j] != target){ //value at current index in list does not match target value?
                //System.out.printf("\n%d != %d", list[j], target); //for debugging
                newArray[k] = list[j];
                
            }
            if (list[j] == target){ //target match?
                k--;    //decrement to keep last valid index
            }
            //System.out.println(j + " " + list[j] + " " + k + " " + newArray[k]); //for debugging
            k++;        //increment index counter for newArray
        }//end for loop
        return newArray;                //return new array
    }//end remove method
    
}