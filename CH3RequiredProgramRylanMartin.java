/*
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
        double premiumFinalCost; //Final cost for premium users

        //'REGULAR' VARIABLES
        final double regularCost = 15.00; //Per month
        int regularMinutes; //Regular Minutes
        final double regularAddedCost = 0.20; //Added cost for minutes past 60
        double regularFinalCost; //Final cost for regular users

        //AM VARIABLES
        int amMinutes; //AM Minutes
        final double amAddedCost = 0.10; //Added cost for minutes past 100
        double amCost; //Cost for AM Minutes

        //PM VARIABLES
        int pmMinutes; //PM Minutes
        final double pmAddedCost = 0.05; //Added cost for minutes past 200
        double pmCost; //Cost for PM Minutes

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

        System.out.println(serviceCode);

        while ((serviceCode != 'R') || (serviceCode != 'r') || (serviceCode != 'P') || (serviceCode != 'p')) {
          //Ask the user again for their Service Code until it is a correct character
          System.out.print("The character you entered is not valid. Please try again. (R/r)egular or (P/p)remium?: ");
          serviceCode = input.next().charAt(0);
  
        //Run calculations for a bill based on the type of service the user has
        if ((serviceCode == 'R') || (serviceCode == 'r')) {
          //Ask for amount of Minutes that have been used and assign value to regularMinutes
          System.out.print("How many Minutes have you used?: ");
          regularMinutes = input.nextInt();
          if (regularMinutes > 60) {
            //Add regularAddedCost to regularCost to get regularFinalCost
            regularFinalCost = regularCost + (regularMinutes * regularAddedCost);
            System.out.printf("%5.2f\n", regularFinalCost);
          }
          else {
            //Print out regularFinalCost without regularAddedCost
            regularFinalCost = regularCost;
            System.out.printf("%5.2f\n", regularFinalCost);
          }
        }

        if ((serviceCode == 'P') || (serviceCode == 'p')) {
          //Ask for amount of AM Minutes that have been used and assign value to amMinutes
          System.out.print("How many AM Minutes have you used?: ");
          amMinutes = input.nextInt();
          if (amMinutes > 100) {
            //Charge $0.10 per minute for any amount of AM Minutes past 100 Minutes
            amCost = amMinutes * amAddedCost;
          }
          //Ask for amount of PM Minutes that have been used and assign value to pmMinutes
          System.out.print("How many PM Minutes have you used?: ");
          pmMinutes = input.nextInt();
          if (pmMinutes > 200) {
            //Charge $0.05 per minute for any amount of PM Minutes past 200 Minutes
            pmCost = pmMinutes * pmAddedCost;
          }
        }
        break;
      } 
  }
}