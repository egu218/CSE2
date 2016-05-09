// Eddison Ugaddan
// May 2, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW 13: Holoporter program transports molecules of an object

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Holoporter{
    public static void main(String[] args){
        String[][][] array3Dstart = soRandom(); //construct ragged 3D array of 
                                                //  randomized dimension sizes
        fill3D(array3Dstart);                   //fill the 3D array representing 
                                                //  the starting condition
        print(array3Dstart);                    //print the 3D array representing
                                                //  the starting condition
        
        String[][][] array3Dend = soRandom();   //construct ragged 3D array of
                                                //  randomized dimension sizes
        
        
        //System.out.println("\n\n\n\n\n"); //for debugging
        //print(array3Dend);                //  purposes
        
        holoport(array3Dstart, array3Dend); //send molecules from starting location to ending location
        System.out.println("\n\n\n\n\n");
        print(array3Dend);                      
        
        sampling(array3Dend, "A1234");
        
    }//end main method
    
    public static String[][][] soRandom(){
        Random rand = new Random();
        String[][][] object = new String[rand.nextInt(10)+1][][];   //generate size of main 3D array
        for (int i = 0; i < object.length; i++){
            object[i] = new String[rand.nextInt(10)+1][];           //generate size of current 2D member array
            for (int j = 0; j < object[i].length; j++){
                object[i][j] = new String[rand.nextInt(10)+1];      //generate size of current 1D member array
            }//end inner for loop
        }//end outer for loop
        return object;                                              //return empty 3D array
    }//end soRandom method
    
    //generate an identifying string of code in format XXYYYY
    //  X being a letter from A to Z
    //  Y being a number from 0 to 9
    public static String coder(){
        Random rand = new Random();
        String molecule = "";
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //'generate' a random letter in range [A,Z] for x1 and x2
        String x1 = String.valueOf(alphabet.charAt(rand.nextInt(alphabet.length())));
        String x2 = String.valueOf(alphabet.charAt(rand.nextInt(alphabet.length())));
        //generate a random number in range [0,9] for y1, y2, y3, and y4
        int y1 = rand.nextInt(10);
        int y2 = rand.nextInt(10);
        int y3 = rand.nextInt(10);
        int y4 = rand.nextInt(10);
        molecule = x1 + x2 + y1 + y2 + y3 + y4;     //append randomized letters and 
                                                    //  numbers to build final code
        return molecule;                            //return final code
    }//end coder method
    
    public static void fill3D(String[][][] array){
        ArrayList<String> usedCodes = new ArrayList<String>();
        boolean redundant = false;
    
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                for (int k = 0; k < array[i][j].length; k++){
                    String code = coder();          //generate new code
                    if (usedCodes.size() == 0){     //usedCodes ArrayList is empty?
                        usedCodes.add(code);        //add most recently generated code
                                                    //  to usedCodes ArrayList
                        array[i][j][k] = code;      //fill current spot in 3D array 
                                                    //  with most recently generated code
                    }//end if statement
                    else {                          //usedCodes ArrayList must contain codes!
                        for (int n = 0; n < usedCodes.size(); n++){
                            //generated code matches an existing assigned code?
                            if (usedCodes.get(n).equalsIgnoreCase(code)){   
                                redundant = true;   //flag generated code as matching
                                                    //  existing code
                                //System.out.println("\tMATCH");    //for debugging
                                k--;    //decrement index to try writing over
                                        //  redundancy on next iteration
                                break;  //break out of looping through usedCodes ArrayList
                            }//end if statement
                        }//end for loop
                        if (redundant == false){    //no redundant code found?
                            usedCodes.add(code);    //add most recently generated code
                                                    //  to usedCodes ArrayList
                        array[i][j][k] = code;      //fill current spot in 3D array 
                                                    //  with most recently generated code    
                        }//end if statement
                    }//end else statement
                }//end inner for loop
            }//end middle for loop
        }//end outer for loop
    }//end fill3D method
    
    public static void print(String[][][] array){
        
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print("[");
                for (int k = 0; k < array[i][j].length; k++){
                    System.out.print(array[i][j][k]);
                    if (k != array[i][j].length-1){
                        System.out.print(", ");
                    }
                    else {
                        System.out.print("] ");
                    }
                }//end inner for loop
                if (j != array[i].length-1){
                    System.out.print("| ");
                }
            }//end middle for loop
            if (i != array.length-1){
                System.out.print("--- ");    
            }
        }//end outer for loop
        System.out.println();
    }//end print method
    
    //holoport method sends over molecules from starting location to ending location 
    //  wherever space is available; parts of starting object may be truncated, or
    //  filler appended to holoported molecules at ending location
    public static void holoport(String[][][] start, String[][][] end){
        String filler = "$$$$$$";
        
        //fill each dimension of the 3D array up to the shorter length of either 3D array
        for (int x = 0; x < end.length && x < start.length; x++){
            for (int y = 0; y < end[x].length && y < start[x].length; y++){
                for (int z = 0; z < end[x][y].length && z < start[x][y].length; z++){
                    end[x][y][z] = start[x][y][z];
                }//end z-for
            }//end y-for
        }//end x-for
        
        for (int a = 0; a < end.length; a++){
            for (int b = 0; b < end[a].length; b++){
                for (int c = 0; c < end[a][b].length; c++){
                    if (end[a][b][c] == null){  //cell requires a filler string?
                        end[a][b][c] = filler;  //assign filler to this cell
                    }//end if
                }//end c-for
            }//end b-for
        }//end a-for
        
    }//end holoport method
    
    public static void sampling(String[][][] array, String term){
        Scanner sc;
        //check for valid user input
        boolean validTerm = true;
        if (term.length() == 6){
            for (int i = 0; i < term.length(); i++){
                if (i < 2){ //check for valid letters?
                    if (!Character.isAlphabetic(term.charAt(i))){ //character at current index not alphabetic?
                        validTerm = false;
                    }
                }
                else { //check for valid digits!
                    if (!Character.isDigit(term.charAt(i))){ //character at current index not a digit?
                        validTerm = false;
                    }
                }
            }//end for loop
        }//end if 
        else {
            validTerm = false;
        }//end else
        while (validTerm == false){
            validTerm = true;   //assume valid unless found otherwise
            System.out.println("\tInvalid search term!" +
                "\tCode must be in format XXYYYY" +
                "\tX is a letter A-Z, Y is a digit 0-9 inclusive");
            System.out.print("Code to search for: ");
            sc = new Scanner(System.in);
            if (sc.hasNext()){
                term = sc.next();
                if (term.length() == 6){
                    for (int i = 0; i < term.length(); i++){
                        if (i < 2){ //check for valid letters?
                            if (!Character.isAlphabetic(term.charAt(i))){ //character at current index not alphabetic?
                                validTerm = false;
                            }
                        }
                        else { //check for valid digits!
                            if (!Character.isDigit(term.charAt(i))){ //character at current index not a digit?
                                validTerm = false;
                            }
                        }
                    }//end for loop
                }//end if
                else {
                    validTerm = false;
                }//end else
            }//end if 
        }//end while loop
        //System.out.println("Exited while loop; term to search for = " + term); //for debugging
        
        
    }//end sampling method
}//end class