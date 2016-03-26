// Eddison Ugaddan
// March 26, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// Lab 9: Story program randomly generates a sentence using hard-coded possible 
//  words; the words used are determined by a Random value; a new random sentence
//  is generated so long as the user desires

import java.util.Random;    //import Random class for generating random values
import java.util.Scanner;   //import Scanner class for getting user input

public class Story{
    public static void main(String[] args){
        //initialize variables
        Random rand = new Random();
        Scanner scan;
        int randomRange;
        String sentence;
        String continueMsg;
        boolean continueLoop;
        
        randomRange = 10;       //range for possible Random values [0,10)
        continueMsg = "Continue?  Type 'Y' or 'y' - otherwise type anything else: ";
        continueLoop = false;   //conditional variable for while loop below
        
        //>>>while loop below generates a new sentence on each loop through, 
        //  so long as user wants to continue looping
        while (!continueLoop){
            sentence = "The ";  //reset String sentence
            
            //build sentence from randomly generated words
            sentence += getAdjective(rand, randomRange) + getSubjectNoun(rand, randomRange)
                + getPastVerb(rand, randomRange) + getArticle(rand)
                + getAdjective(rand, randomRange) + getObjectNoun(rand, randomRange) + ".";
            System.out.println(sentence);   //print the generated sentence
            
            System.out.print(continueMsg);  //ask if user wants to continue 
                                            //  generating another sentence
            scan = new Scanner(System.in);  //assign new Scanner Object to read user input
            if (!scan.next().equalsIgnoreCase("y")){    //input enters anything other
                                                        //  than 'y' or 'Y'?
                System.out.println("Goodbye!");         //prints exit message
                continueLoop = true;                    //adjust conditional variable
                                                        //  for this while loop to allow 
                                                        //  break out of loop
            }//end if statement
        }//end while loop
    }//end main method
    
    //method getAdjective returns a String adjective
    //  parameter of a Random Object and Integer range for possible Random values
    public static String getAdjective(Random randomObj, int range){
        int num = randomObj.nextInt(range); //generate a random number!
        String word = "";   //placeholder variable for return String
        switch (num){   //compare generated random number
            case 0:
                word = "vivacious";
                break;
            case 1:
                word = "adorable";
                break;
            case 2:
                word = "lively";
                break;
            case 3:
                word = "bumbling";
                break;
            case 4:
                word = "vicious";
                break;
            case 5:
                word = "wicked";
                break;
            case 6:
                word = "confused";
                break;
            case 7:
                word = "angry";
                break;
            case 8:
                word = "starved";
                break;
            default:    //Random number generated must be 9!
                word = "fabulous";
                break;
        }//end switch statement
        return word + " ";    //return updated adjective after switch selection
    }//end getAdjective method
    
    //method getSubjectNoun returns a String subject noun;
    //  parameter of a Random Object and Integer range for possible Random values
    public static String getSubjectNoun(Random randomObj, int range){
        int num = randomObj.nextInt(range); //generate a random number!
        String word = "";   //placeholder variable for return String
        switch (num){   //compare generated random number
            case 0:
                word = "elephant";
                break;
            case 1:
                word = "mouse";
                break;
            case 2:
                word = "koala";
                break;
            case 3:
                word = "manatee";
                break;
            case 4:
                word = "kangaroo";
                break;
            case 5:
                word = "witch";
                break;
            case 6:
                word = "lion";
                break;
            case 7:
                word = "swordsman";
                break;
            case 8:
                word = "king";
                break;
            default:    //Random number generated must be 9!
                word = "queen";
                break;
        }//end switch statement
        return word + " ";    //return updated subject noun after switch selection
    }//end getSubjectNoun method
    
    //method getObjectNoun returns a String past verb;
    //  parameter of a Random Object and Integer range for possible Random values
    public static String getPastVerb(Random randomObj, int range){
        int num = randomObj.nextInt(range); //generate a random number!
        String word = "";   //placeholder variable for return String
        switch (num){   //compare generated random number
            case 0:
                word = "hopped over";
                break;
            case 1:
                word = "serenaded";
                break;
            case 2:
                word = "piggybacked";
                break;
            case 3:
                word = "trundled by";
                break;
            case 4:
                word = "skipped by";
                break;
            case 5:
                word = "lollygagged near";
                break;
            case 6:
                word = "stalked";
                break;
            case 7:
                word = "wept behind";
                break;
            case 8:
                word = "deferred to";
                break;
            default:    //Random number generated must be 9!
                word = "worshipped";
                break;
        }//end switch statement
        return word + " ";    //return updated past verb after switch selection
    }//end getPastVerb method
    
    //method getObjectNoun returns a String object noun;
    //  parameter of a Random Object and Integer range for possible Random values
    public static String getObjectNoun(Random randomObj, int range){
        int num = randomObj.nextInt(range); //generate a random number!
        String word = "";   //placeholder variable for return String
        switch (num){   //compare generated random number
            case 0:
                word = "soldier";
                break;
            case 1:
                word = "priest";
                break;
            case 2:
                word = "dancer";
                break;
            case 3:
                word = "sprinter";
                break;
            case 4:
                word = "ghost";
                break;
            case 5:
                word = "goblin";
                break;
            case 6:
                word = "maniac";
                break;
            case 7:
                word = "cheese";
                break;
            case 8:
                word = "orangutan";
                break;
            default:    //Random number generated must be 9!
                word = "pomegranate";
                break;
        }//end switch statement
        return word;    //return updated object noun after switch selection
    }//end getObjectNoun method
    
    //method getArticle returns a String article word;
    //  parameter of a Random Object
    public static String getArticle(Random randomObj){
        int num = randomObj.nextInt(3); //generate a random number!
        String word = "";   //placeholder variable for return String
        switch (num){   //compare generated random number
            case 0:
                word = "the";
                break;
            case 1:
                word = "this";
                break;
            default:
                word = "that";
                break;
        }//end switch statement
        return word + " ";    //return updated article after switch selection
    }//end getArticle method
}//end class