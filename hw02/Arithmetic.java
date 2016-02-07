/*  Eddison Ugaddan
    February 9, 2016
    Prof. Brian Chen
    CSE 002 Section 111

    HW02: Arithmetic - program that functions as a receipt, calculating and printing 
       individual item costs, individual sales tax, and total item cost as well as total sales tax
     
    NOTE: I created a method below the main method to facilitate the truncating of numbers
       with many decimal places down to two decimals - representing USD currency
*/

public class Arithmetic{
    public static void main(String[] args){
       
       //following individual item prices
       double priceSantaHats = 14.89;
       double priceUglySweaters = 21.58;
       double priceCocoaMix = 2.67;
       double priceAppleCider = 3.89;
       double pricePumpkinPie = 5.27;
       
       //following quantity of items bought
       int qtySantaHats = 2;
       int qtyUglySweaters = 1;
       int qtyCocoaMix = 4;
       int qtyAppleCider = 2;
       int qtyPumpkinPie = 2;
       
       //constant of the local sales tax
       double localSalesTax = 0.06;
       
       //following calculations of cost before tax of individual item type
       double costSantaHats = priceSantaHats*qtySantaHats;
       double costUglySweaters = priceUglySweaters*qtyUglySweaters;
       double costCocoaMix = priceCocoaMix*qtyCocoaMix;
       double costAppleCider = priceAppleCider*qtyAppleCider;
       double costPumpkinPie = pricePumpkinPie*qtyPumpkinPie;
       
       //following calculations of individual item type sales tax
       double txSantaHats = costSantaHats*localSalesTax;
       double txUglySweaters = costUglySweaters*localSalesTax;
       double txCocoaMix = costCocoaMix*localSalesTax;
       double txAppleCider = costAppleCider*localSalesTax;
       double txPumpkinPie = costPumpkinPie*localSalesTax;
       
       //calculation of total cost of items
       double totalCostItems = costSantaHats + costUglySweaters + costCocoaMix + 
        costAppleCider + costPumpkinPie;
           
        
       //calculation of total sales tax
       double totalSalesTax = txSantaHats + txUglySweaters + txCocoaMix +
        txAppleCider + txPumpkinPie;
       
       //calculation of total purchase made
       double totalPurchase = totalCostItems + totalSalesTax;
       
       //following method calls function to truncate the input down to two decimal places
       //   formula explained in homework assignment
       double taxHats = truncateToTwoDecimals(txSantaHats);
       double taxSweaters = truncateToTwoDecimals(txUglySweaters);
       double taxCocoa = truncateToTwoDecimals(txCocoaMix);
       double taxCider = truncateToTwoDecimals(txAppleCider);
       double taxPie = truncateToTwoDecimals(txPumpkinPie);
       double allItemsCost = truncateToTwoDecimals(totalCostItems);
       double allItemsTax = truncateToTwoDecimals(totalSalesTax);
       double payDue = truncateToTwoDecimals(totalPurchase);
       
       //following print statements prints item type costs before tax, sales tax for each item, 
       //   total items cost before tax, total sales tax for all items, and grand sum total of the purchase
       System.out.println("-------------------------Your Very Detailed Receipt!--------------------------");
       System.out.println("Individual Item Type Costs (before sales tax) | Individual Item Type Sales Tax");
       System.out.println("Ho-Ho-Ho! Santa Hat:             $" + costSantaHats + "       |             $" + taxHats);
       System.out.println("Grandma Suzy's Sweater:          $" + costUglySweaters + "       |             $" + taxSweaters);
       System.out.println("Swiss Chocolate Mix:             $" + costCocoaMix + "       |             $" + taxCocoa);
       System.out.println("Farmer's Orchard Apple Cider:    $" + costAppleCider + "        |             $" + taxCider);
       System.out.println("SweetTooth Desserts Pumpkin Pie: $" + costPumpkinPie + "       |             $" + taxPie);
       
       System.out.println("\nTotal Cost of All Items (before sales tax: $" + allItemsCost);
       System.out.println("Total Sales Tax of All Items:              $" + allItemsTax);
       
       System.out.println("Total PAYMENT DUE:                         $" + payDue + "\n");
       System.out.println("-----------------------Thank You for Shopping With Us!------------------------");
       
    } //end main method
    
    //following method takes in one input of a double, and outputs a double
    //   the method truncates the input double down to two decimal places, which it outputs
    public static double truncateToTwoDecimals(double reallyLongDecimal){
       reallyLongDecimal *= 100;                        //multiply long decimal by 100
       int truncatedDecimal = (int)reallyLongDecimal;   //explicitly cast double to int, 
                                                        //  truncate (chop off) all decimals,
                                                        //  leaving an integer
       double shortDecimal = truncatedDecimal;          //implicitly cast int to double,
       shortDecimal /= 100;                             //  and divide truncated decimal by 100,
                                                        //  leaving a number with two decimal places
       return shortDecimal;                             //output the original decimal
                                                        //  truncated to two decimal places
                                                        //  *two places to represent currency 
                                                        //  e.g. $1.99
    } // end truncateToTwoDecimals method
} //end Arithmetic class