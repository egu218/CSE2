// Eddison Ugaddan
// March 29, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW09: Games program walks the user through three possible minigames to play:
//  1) guessTheBox: user must choose a box numbered 1-3; the prize box
//  is determined by a random number generator
//  2) spinTheWheel: user must choose a color and number from a wheel which is split 
//  into 10 sections, 5 of which are red, the other 5 being black; the wheel is then
//  'spun' - i.e. color and number values are generated; user wins when the 
//  generated values match user input
//  3) scrambler: user inputs one word; the word is scrambled by swapping the 
//  character at a randomly chosen index position with the character in the first
//  index position; swapping is iterated a random number of times

import java.util.Scanner;
import java.util.Random;

public class Games{
    public static void main(String[] args){
        Scanner scan;
        String welcomeMsg;
        String chooseRequest;
        String inputHeader;
        String gameDesired;
        String gameChosen;
    
        welcomeMsg = "Welcome to Rudimentary Games!";
        chooseRequest = "Choose a game!" +
            "\n\tguessTheBox" +
            "\n\tspinTheWheel" +
            "\n\tscrambler" +
            "\n(Enter the name of the game you want, as shown above)";
        inputHeader = ">> ";
        
        System.out.println(welcomeMsg);
        
        while (true){
            System.out.println(chooseRequest);
            System.out.print(inputHeader);
            scan = new Scanner(System.in);
            gameDesired = scan.next();
            gameChosen = chooseGame(gameDesired);   //check user input 
                                                    //  for valid game desired
            
            if (gameChosen == null){    //invalid game desired?
                break;  //exit while loop!
            }//end if statement
            System.out.println("Let's play: " + gameChosen + "!");
            
            if (gameChosen.equalsIgnoreCase("guessTheBox")){    //chosen game is guessTheBox?
                guessTheBox();      //call guessTheBox() method
            }//end if statement
            else if (gameChosen.equalsIgnoreCase("spinTheWheel")){  //chosen game is spinTheWheel?
                spinTheWheel();     //call spinTheWheel() method
            }//end else if statement
            else {  //chosen game must be scrambler!
                scrambler();        //call scrambler() method
            }//end else statement
        }//end while loop
    }//end main method
    
    /**
     * chooseGame method checks the inputted String representing the game desired
     *  with actually available games
     * parameter(s): String
     * return type: String
    */
    public static String chooseGame(String gmDesired){
        //initialize local variables
        String game;
        String gm1;
        String gm2;
        String gm3;
        String noGm;
        
        game = "";
        gm1 = "guessTheBox";
        gm2 = "spinTheWheel";
        gm3 = "scrambler";
        noGm = "No such game found!";

        if (gmDesired.equalsIgnoreCase(gm1)){ //user typed in "guessTheBox"?
            game = gm1;  
        }//end if statement
        else if (gmDesired.equalsIgnoreCase(gm2)){ //user typed in "spinthewheel"?
            game = gm2;
        }//end else if statement
        else if (gmDesired.equalsIgnoreCase(gm3)){ //user typed in "scrambler"?
            game = gm3;
        } //end else if statement
        else { //user input must not match any available games on stock!
            System.out.println("Exiting: " + noGm); //print exit message
            return null;
        }//end else statement
        
        return game;    //return updated String variable game
    }//end chooseGame method
    
    /**
     * guessTheBox method contains the code for playing the guessTheBox minigame
     * parameter(s): nothing
     * return type: nothing
     */ 
    public static void guessTheBox(){
        //initialize local variables
        Random rand;
        Scanner sc;
        String gameRules;
        String rqstGuess;
        String errorIntMsg;
        String errorRangeMsg;
        String winMsg;
        String loseMsg;
        int randRange;
        int userGuess;
        
        rand = new Random();
        gameRules = "\tThree boxes lie in front of you..." +
            "\n\tYet only one contains a prize." +
            "\n\tChoose the right box; win the prize!" +
            "\n\t(Type in a number 1 to 3)" +
            "\n\t(Enter '.' at any time to EXIT to main menu.)";
        rqstGuess = "Boxes have been shuffled.  Take a gander: ";
        errorIntMsg = "Need an integer - try again!";
        errorRangeMsg = "Need an integer [1,3] - try again!";
        winMsg = "***Cooongratulations!  You won the prize!***";
        loseMsg = "***...My condolences for your loss...***";
        randRange = 3;
        
        System.out.println(gameRules);
        
        while (true){   //loop forever until break encountered
            //generate random number in possible range of [1,3]
            int prizeBox = rand.nextInt(randRange)+1; 
            System.out.print(rqstGuess);    //print request for user to guess
                                            //  the number of the prize box
            sc = new Scanner(System.in);    //initialize new Scanner object
            if (!sc.hasNextInt()){  //next token is not an Integer?
                System.out.println(errorIntMsg); //print integer error message
                if (sc.next().equalsIgnoreCase(".")){ //user entered '.'?
                    break;          //break out of this while loop
                }//end if statement
            }//end if statement
            else {  //user input is an Integer!
                userGuess = sc.nextInt();   //assign next Integer
                if (userGuess < 1 || userGuess > randRange){ //input is outside
                                                             // valid range?
                    System.out.println(errorRangeMsg);  //print range error message
                }//end if statement
                else {  //user input is in valid range!
                    if (userGuess == prizeBox){ //user guessed prize box?
                        System.out.println(winMsg);     //print winner's message
                    }//end if statement
                    else { //user must have guessed wrong!
                        System.out.println(loseMsg);    //print loser's message
                    }//end else statement
                }//end else statement
            }//end else statement    
        }//end while loop
    }//end guessTheBox method
    
    /**
     * spinTheWheel method contains the code for playing the spinTheWheel minigame
     * parameter(s): nothing
     * return type: nothing
     */ 
    public static void spinTheWheel(){
        //initialize local variables
        Random rand;
        Scanner sc;
        String gameRules;
        String color1;
        String color2;
        String prizeColor;
        String rqstGuess;
        String colorGuess;
        String colorErrorMsg;
        String numErrorMsg;
        String numRangeErrorMsg;
        String winMsg;
        String loseMsg;
        int colorRange;
        int numRange;
        int numGuess;
        
        rand = new Random();
        gameRules = "\tThe wheel is split into ten sections;" +
            "\n\tfive of them are red, five are black." +
            "\n\tGuess the right color black or red" +
            "\n\tAND number [1,5] - and win a prize!" +
            "\n\t(e.g. black 5)" +
            "\n\t(Enter '.' at any time to EXIT to main menu.)";
        color1 = "black";
        color2 = "red";
        rqstGuess = "Wheel is spinning... Take a gander: ";
        colorErrorMsg = "Did you enter a valid color, red or black?  Try again!";
        numErrorMsg = "Need an integer - try again!";
        numRangeErrorMsg = "Need an integer [1,5] - try again!";
        winMsg = "***Cooongratulations!  You won the prize!***";
        loseMsg = "***...My condolonces for your loss...***";
        colorRange = 2;
        numRange = 5;
        
        System.out.println(gameRules);
        
        while (true){
            prizeColor = "";
            //generate random numbers below corresponding 
            //  to a color black or red, and number [1,5]
            int spunColor = rand.nextInt(colorRange);   
            int spunNum = rand.nextInt(numRange)+1;
            
            if (spunColor%2 == 0){ //generated random number for color was even?
                prizeColor = color1;    //assign prize color as black
            }//end if statement
            else { //generated random number for color was odd!
                prizeColor = color2;    //assign prize color as red
            }//end else statement
            
            System.out.print(rqstGuess);    //print request for user to input
                                            //  guess for the color and number
                                            //  the spun wheel will land on
            sc = new Scanner(System.in);
            colorGuess = sc.next();
            
            if (colorGuess.equalsIgnoreCase(".")){ //user entered '.'?
                    break;          //break out of this while loop
            }//end if statement
            //color guessed is neither "black" nor "red"?
            if (!colorGuess.equalsIgnoreCase(color1) && !colorGuess.equalsIgnoreCase(color2)){
                System.out.println(colorErrorMsg);  //print color error message
            }//end if statement
            else {  //first token matched a color!
                if (!sc.hasNextInt() || !sc.hasNext()){  //next token not an Integer?
                    System.out.println(numErrorMsg);
                }//end if statement
                else {  //next token must be an Integer!
                    numGuess = sc.nextInt();    //assign Integer token to numGuess
                    if (numGuess < 1 || numGuess > 5){  //guessed number is outside valid range?
                        System.out.println(numRangeErrorMsg);   //print range error message
                    }//end if statement
                    else {  //guessed number must be inside valid range!
                        if (colorGuess.equalsIgnoreCase(prizeColor) &&
                            numGuess == spunNum){   //guessed color and number match
                                                    //  correct wheel color and number?
                                System.out.println(winMsg); //print winner's message
                        }//end if statement
                        else {  //one or neither input match...
                            System.out.println(loseMsg);    //print loser's message
                        }//end else statement
                    }//end else statement
                }//end else statement
            }//end else statement
        }//end while loop
    }//end spinTheWheel() method
    
    /**
     * scrambler method contains the code for playing the scrambler minigame
     * parameter(s): nothing
     * return type: nothing
     */ 
    public static void scrambler(){
        //initialize local variables
        Scanner sc;
        Random rand;
        String gameRules;
        String rqstWord;
        String finalWord;
        String userWord;
        String initialWord;
        String lengthErrorMsg;
        String letterErrorMsg;
        String charToSwap;
        String firstChunk;
        String firstChar;
        String lastChunk;
        int wordLength;
        boolean validInput;
        
        rand = new Random();
        gameRules = "\tFeed me a word, and I'll scramble it for you!" +
            "\n\t(Enter '.' at any time to EXIT to main menu.)";
        rqstWord = "Word to be scrambled: ";
        lengthErrorMsg = "Word must be at least 2 letters.  Try again!";
        letterErrorMsg = "Need a word containing alphabet letters.  Try again!";
        
        System.out.println(gameRules);              //print game rules
        
        scramble:       //label for while loop below
        while (true){   //loop forever until break encountered
            finalWord  = "";
            
            System.out.print(rqstWord);             //print request for a word
            sc = new Scanner(System.in);            //read user input
            
            userWord = sc.next();                   //assign userWord as first token
                                                    //  found in user input
            initialWord = userWord;                 //assign placeholder variable
                                                    //  for inputted word
            wordLength = initialWord.length();      //get length of inputted word
            
            if (wordLength == 1){                   //input is only 1 character long?
                if (userWord.equalsIgnoreCase(".")){    //input was '.'?
                    break scramble;                 //break out of while loop labeled scramble
                }//end if statement
                System.out.println(lengthErrorMsg); //print length error message
            }
            else {  //word is of valid length!
                validInput = true;                      //input is assumed default true
                for (int i = 0; i < wordLength; i++){   //loop through each letter in the word
                    //character at current index is not an alphabet letter?
                    if (!Character.isAlphabetic(userWord.charAt(i))){ 
                        validInput = false; //non-alphabet letter encountered so flag false
                        break;  //break out of this for loop
                    }//end if statement
                }//end for loop
                
                if (!validInput){   //invalid input?
                    System.out.println(letterErrorMsg);     //print letter error message
                }
                else {              //input must be valid!
                    int randSwapNum = rand.nextInt(9)+3;    //generate a swap number 
                                                            //  in range [3,11]... arbitrary
                    for (int n = 1; n <= randSwapNum; n++){
                        int randIndex = rand.nextInt(wordLength-1)+1;   //generate random number with
                                                                        //  possible range of [1,7];
                                                                        //  index 0 excluded so 
                                                                        //  first character is not 
                                                                        //  swapped with first character
                                                                        //  i.e. same word is not returned
                        //get character at index position randIndex
                        charToSwap = Character.toString(initialWord.charAt(randIndex)); 
                        //get chunk of letters after first character and 
                        //  before the character at position randIndex
                        firstChunk = initialWord.substring(1, randIndex);
                        //get character at first index position
                        firstChar = Character.toString(initialWord.charAt(0));
                        //get chunk of letters after character at position randIndex
                        // until end of word
                        lastChunk = initialWord.substring(randIndex+1, wordLength);
                        //build scrambled word
                        initialWord = charToSwap + firstChunk + firstChar + lastChunk;
                    }//end for loop
                    
                    finalWord = initialWord.toLowerCase();  //assign as final word the last
                                                            //  scrambled word
                    System.out.println(finalWord);  //print final scrambled word
                }//end else statement
            }//end else statement   
        }//end while loop
    }//end scrambler method
}// end class