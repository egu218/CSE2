// Eddison Ugaddan
// February 19, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// Lab 4: CardGenerator program randomly generates a number [1,52] inclusive, each 
//  representing a card in a deck - [1,13] Clubs, [14,26] Hearts, [27-39] Spades, [40-52] Diamonds
//  and prints out the number's corresponding suit and identity


public class CardGenerator{
    public static void main(String[] args){
        int randomNum = (int)((Math.random()*52)+1);    //call on Math class's random() method 
                                                        //  to generate a number [1-52] inclusive
        String suitCard = "";                           //initialize suitCard String variable
        String identityCard = "";                       //initialize identityCard String variable
        
        //in the following if/else-if statements: assign suit 
        //  depending on range random number falls in
        if (randomNum >= 1 && randomNum <= 13){
            suitCard = "Clubs";
        }
        else if (randomNum >= 14 && randomNum <= 26){
            suitCard = "Hearts";
        }
        else if (randomNum >= 27 && randomNum <= 39){
            suitCard = "Spades";
        }
        else {
            suitCard = "Diamonds";
        } 
        
        int indexCard = randomNum % 13; //how many 13's fit in the generated number... return remainder
        
        switch (indexCard){     //compare the following cases to the indexCard
            case 1:             //remainder 1
                identityCard = "Ace";       //assign identityCard variable
                System.out.printf("You brandish the %s of %s\n",identityCard, suitCard);  //print!
                break;
            case 11:            //remainder 11
                identityCard = "Jack";      //assign identityCard variable
                System.out.printf("You brandish the %s of %s\n",identityCard, suitCard);  //print!
                break;
            case 12:            //remainder 12
                identityCard = "Queen";     //assign identityCard variable
                System.out.printf("You brandish the %s of %s\n",identityCard, suitCard);  //print!
                break;
            case 0:             //remainder 0 because 13%13 = 26%13 = 39%13 = 52%13 = 0
                identityCard = "King";      //assign identityCard variable
                System.out.printf("You brandish the %s of %s\n",identityCard, suitCard);  //print!
                break;
            default:
                identityCard = indexCard + "";  //cast indexCard integer to String and 
                                                //  assign to identityCard variable
                System.out.printf("You brandish the %s of %s\n",identityCard, suitCard);  //print!
                break;
        }
        
    }//end main method
}//end class