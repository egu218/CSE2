// Eddison Ugaddan
// February 5, 2016
// Prof. Brian Chen
// CSE 002 Section 111

// Lab 2: Bicycle Cyclometer program calculates and prints time in minutes of a trip, 
//  front wheel revolutions count, distance traveled in a trip, and total distance in miles of two trips

public class Cyclometer{
    
    public static void main(String[] args){     //main method to run program
        int secsTrip1 = 10813;          //raw input of seconds that trip1 took
        int secsTrip2 = 1758;           //raw input of seconds that trip2 took
        int revCount1 = 20168;          //raw input of number of revolutions made 
                                        //  by front wheel in trip1
        int revCount2 = 3543;           //raw input of number of revolutions made 
                                        //  by front wheel in trip2
        
        double wheelDiameter = 27;      //constant of diameter of wheel in inches
        double pi = 3.14159;            //constant of pi
        int ftPerMile = 5280;           //constant of feet per mile
        int inPerFt = 12;               //constant of inches per foot
        int secPerMin = 60;             //constant of seconds per minute
        
        double distance1;               //initialize variable to hold distance from trip1
        double distance2;               //initialize variable to hold distance from trip2
        
        //following two print statements print minutes taken and revolutions made by both trips
        System.out.println("Trip 1 took " + (secsTrip1/secPerMin) + " minutes; had " +
            (revCount1) + " front wheel revolutions.");
        System.out.println("Trip 2 took " + (secsTrip2/secPerMin) + " minutes; had " +
            (revCount2) + " front wheel revolutions.");
        
        //following two variable assignements are found by calculations and converting inches to miles
        distance1 = revCount1*pi*wheelDiameter/inPerFt/ftPerMile;     
        distance2 = revCount2*pi*wheelDiameter/inPerFt/ftPerMile;     
        
        double totalDistance = distance1+distance2;     //total distance as sum of the distances of both trips
        
        //following three print statements print trip1 and trip2 distances, and the total distance
        System.out.println("Trip 1 was over " + distance1 + " miles.");
        System.out.println("Trip 2 was over " + distance2 + " miles.");
        System.out.println("Total distance: " + totalDistance + " miles.");
        
        
    } //end main method
    
    
} //end class