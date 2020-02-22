/*
Rylan Martin - 02.17.2020 - CH3 Required Program

This program calculates and prints a bill for a cellular phone company (Java Mobile).
The user is prompted for their last name, account number, service code, and number
of minutes used. There are two types of service, Regular and Premium. The receipt 
prints out the information that was given by the user, as well as the total cost 
for the bill.
*/

package ch3.required.program.rylan.martin;
import java.util.Scanner;
/*
@author rmartin427
*/
public class CH3RequiredProgramRylanMartin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Create new Scanner
        Scanner input = new Scanner(System.in);

        //Working Variables
        String lastName = " "; //Last Name of the current user
        int accountNumber; //User Account Number
        char serviceCode; //P or p for Premium, R or r for Regular

        //'PREMIUM' VARIABLES
        final double premiumCost = 30.00; //Per month
        double premiumFinalCost; //Final cost for premium user
        
        //'REGULAR' VARIABLES
        final double regularCost = 15.00; //Per month
        int regularMinutes; //Regular Minutes
        final double regularAddedCost = 0.20; //Added cost for minutes past 60
        double regularFinalCost; //Final cost for regular users
        int regularMinutesDifference; //The amount of minutes that are past the free limit
        double regularMinutesDifferenceCost = 0.0; //Cost of minutes after free limit

        //AM VARIABLES
        int amMinutes; //AM Minutes
        final double amAddedCost = 0.10; //Added cost for minutes past 100
        double amCost = 0; //Cost for AM Minutes
        double amFinalCost; //Final cost for AM Minutes
        int amMinutesDifference; //Variable for amount of minutes that are past AM free limit
        double amMinutesDifferenceCost = 0; //Cost of minutes after free limit
        

        //PM VARIABLES
        int pmMinutes; //PM Minutes
        final double pmAddedCost = 0.05; //Added cost for minutes past 200
        double pmCost = 0; //Cost for PM Minutes
        double pmFinalCost; //Final cost for PM Minutes
        int pmMinutesDifference; //Variable for amount of minutes past free limit
        double pmMinutesDifferenceCost = 0; //Cost of minutes after free limit
        
        //Description of code for user
        System.out.println("This program calculates and prints a bill for a cellular phone company (Java Mobile).\n" +
                           "The user is prompted for their last name, account number, service code, and number\n" +
                           "of minutes used. There are two types of service, Regular and Premium. The receipt \n" +
                           "prints out the information that was given by the user, as well as the total cost \n" +
                           "for the bill.");

        //Prompt user for their last last name, then store the input in lastName
        System.out.print("Welcome to Java Mobile! What is your last name?: ");
        lastName = input.nextLine();

        //Prompt user for their account number, then store the input in
        //accountNumber
        System.out.print("Next, would you please provide your account number?: ");
        accountNumber = input.nextInt();
        
        //Propmt user for a service code (R/r or P/p), the assign the char to 
        //serviceCode.
        System.out.print("Which type of service? (R/r)egular or (P/p)remium?: ");
        serviceCode = input.next().charAt(0);


        while ((serviceCode != 'R') && (serviceCode != 'r') && (serviceCode != 'P') && (serviceCode != 'p')) {
          //Ask the user again for their Service Code until it is a correct character
          System.out.print("The character you entered is not valid. Please try a"
                  + "gain. (R/r)egular or (P/p)remium?: ");
          serviceCode = input.next().charAt(0);
        }
  
        //Run calculations for a bill based on the type of service the user has
        if ((serviceCode == 'R') || (serviceCode == 'r')) {
          //Ask for amount of Minutes that have been used and assign value to regularMinutes
          System.out.print("How many Minutes have you used?: ");
          regularMinutes = input.nextInt();
          if (regularMinutes > 60) {
            //Find Difference
            regularMinutesDifference = regularMinutes - 60;
            //Find cost of difference
            regularMinutesDifferenceCost = regularMinutesDifference * regularAddedCost; 
            //Add regularMinutesDifferenceCost to regularCost to get regularFinalCost
            regularFinalCost = regularCost + regularMinutesDifferenceCost;
            System.out.printf("\n\nTELEPHONE BILL FOR %s         ACCOUNT NBR: %d    "
                    + "     TYPE OF SERVICE: %c\n", lastName, accountNumber, serviceCode);
            System.out.printf("Number of Minutes used: %d    Cost per minute: $%"
                    + ".2f    Charges: %d * $%.2f\n",regularMinutes,regularAddedCost,regularMinutesDifference,regularMinutesDifferenceCost);
            System.out.println("                                                "
                    + "            ______________\n");
            System.out.printf("                                           Total "
                    + "Charges:           $%.2f\n", regularFinalCost);
          }
          else {
            //Print out regularFinalCost without regularAddedCost
            regularFinalCost = regularCost;
            System.out.printf("\n\nTELEPHONE BILL FOR %s         ACCOUNT NBR: %d    "
                    + "     TYPE OF SERVICE: %c\n", lastName, accountNumber, serviceCode);
            System.out.printf("Number of Minutes used: %d      Cost per minute: "
                    + "$%.2f       Charges: %d * $%.2f\n", regularMinutes, regularAddedCost, regularMinutes, regularMinutesDifferenceCost);
            System.out.println("                                                "
                    + "                  ______________\n");
            System.out.printf("                                                      "
                    + "Total Charges:      $%.2f\n", regularFinalCost);
          }
        }

        if ((serviceCode == 'P') || (serviceCode == 'p')) {
          //Ask for amount of AM Minutes that have been used and assign value to amMinutes
          System.out.print("How many AM Minutes have you used?: ");
          amMinutes = input.nextInt();
          if (amMinutes > 100) {
            //Find the difference
            amMinutesDifference = amMinutes - 100;
            //Find Cost of Difference
            amMinutesDifferenceCost = amMinutesDifference * amAddedCost;
            //Add amMinutesDifferenceCost to amCost to get amFinalCost
            amFinalCost = amCost + amMinutesDifferenceCost;
          }
          else {
            //amFinalCost without minute difference
            amFinalCost = amCost;
          }
          
          //Ask for amount of PM Minutes that have been used and assign value to pmMinutes
          System.out.print("How many PM Minutes have you used?: ");
          pmMinutes = input.nextInt();
          if (pmMinutes > 200) {
            //Find the difference
            pmMinutesDifference = pmMinutes - 200;
            //Find Cost of Difference
            pmMinutesDifferenceCost = pmMinutesDifference + pmAddedCost;
            //Add pmMinutesDifference to pmCost to get pmFinalCost
            pmFinalCost = pmCost + pmMinutesDifferenceCost;
          }
          else {
            //pmFinalCost wihtout minute difference
            pmFinalCost = pmCost;
          }
          
          premiumFinalCost = premiumCost + amFinalCost + pmFinalCost; //Calculate premiumFinalCost
          
          //Receipt formatting
          System.out.printf("\n\nTELEPHONE BILL FOR %s         ACCOUNT NBR: %d    "
                  + "     TYPE OF SERVICE: %c\n", lastName, accountNumber, serviceCode);
          System.out.printf("Number of AM Minutes used: %d    Cost per minute: $%"
                  + ".2f    Charges: $%.2f + $%.2f\n",amMinutes,amAddedCost,premiumCost,amMinutesDifferenceCost);
          System.out.printf("Number of PM Minutes used: %d    Cost per minute: $%"
                  + ".2f    Charges: $%.2f + $%.2f\n",pmMinutes,pmAddedCost,premiumCost,pmMinutesDifferenceCost);
          System.out.println("                                                "
                  + "                      ______________\n");
          System.out.printf("                                                 "
                  + " Total Charges:              $%.2f\n", premiumFinalCost);        
        }
    } 
}
