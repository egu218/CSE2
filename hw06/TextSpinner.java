// Eddison Ugaddan
// March 8, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// HW06: TextSpinner program prints a series of single characters each followed by 
//  a backspace and delay, to create the illusion of a rotating line
// NOTE: Found sleep() solution via Stack Overflow forums

public class TextSpinner{
    public static void main(String[] args){
        //initialize variables
        int delay = 67; //how many milliseconds in between each print statement?
        int phase = 1;  //variable holding which print phase the while loop is on
        
        /*>>>while loop below prints a different a line character: \, -, /, or |
            depending on what phase the loop is on, 
            followed by printing the escape character \b,
            and employing a time delay at the end of each loop
        */
        while (true){   //run forever, until break!
            if (phase > 4){ //when last phase is passed,
                phase = 1;  //  reset to first phase
            }//end if statement
            switch (phase){ //compare current phase number
                case 1:     //is it phase 1?
                    System.out.print("\\"); //print '\'
                    break;
                case 2:     //is it phase 2?
                    System.out.print("-");  //print '-'
                    break;
                case 3:     //is it phase 3?
                    System.out.print("/");  //print '\'
                    break;
                default:    //it must be phase 4!
                    System.out.print("|");  //print '/'
                    break;
            }//end switch statement
            System.out.print("\b");         //print backspace
            phase++;        //increment phase number
            
            try {
                Thread.sleep(delay);   //sleep for 'delay' milliseconds             
            } 
            catch (InterruptedException ex){
                Thread.currentThread().interrupt();
                break;
            }
        }//end while loop
    }//end main method
}//end class