/*
Rylan Martin - 3.3.2020 - CH4 Required Program
This program acts as a football scoreboard for the Fall Season. A banner will 
display with a description of the program with a prompt to enter both team
names following that. A for loop will go through each quarter and will ask for 
total touchdowns and total field goals. The score will be calculated once it is 
complete. If there is a tie at the end of the 4 quarters, then a do..while loop
will run for overtime.
*/
package ch4.required.program.rylan.martin;
import java.util.Scanner;
/**
* @author Rylan Martin
*/
public class CH4RequiredProgramRylanMartin {

    public static void main(String[] args) {
        //New Scanner
        Scanner input = new Scanner(System.in);
        
        //Working Variables
        final int touchDown = 7; //Total points for a touchdown
        final int fieldGoal = 3; //Total points for a field goal
        int quarter; //Quarters for the foootball game
        int team1Score; //Team 1 Score
        int team1TDTotal = 0; //Team 1 Total Touchdowns
        int team1TDOvertime; //Team 1 Touchdowns in overtime
        int team1TDOvertimeTotal = 0; //Team 1 Total Touchdowns in overtime
        int team1FGTotal = 0; //Team 1 Total Field Goals
        int team1FGOvertime; //Team 1 Field Goals in overtime
        int team1FGOvertimeTotal = 0; //Team 1 Total Field Goals in overtime
        int team2Score; //Team 2 Score
        int team2TDTotal = 0; //Team 2 Total Touchdowns
        int team2TDOvertime; //Team 2 Touchdowns in overtime
        int team2TDOvertimeTotal = 0; //Team 2 Total Touchdowns in overtime
        int team2FGTotal = 0; //Team 2 Total Field Goals
        int team2FGOvertime; //Team 2 Field Goals in overtime
        int team2FGOvertimeTotal = 0; //Team 2 Total Field Goals in overtime
        String team1Name; //Team 1 Name
        int team1TD; //Team 1 Touchdowns total
        int team1FG; //Team 1 Field Goals total
        String team2Name; //Team 2 Name
        int team2TD; //Team 2 Touchdowns total
        int team2FG; //Team 2 Field Goals total
        
        //Description of the program
        System.out.println("This program acts as a football scoreboard for the Fall Season. This program will prompt "
                         + "the user to enter both team\n" +
                           "names. A for loop will go through each quarter and will ask for \n" +
                           "total touchdowns and total field goals. The score will be calculated once it is \n" +
                           "complete. If there is a tie at the end of the 4 quarters, then a do..while loop\n" +
                           "will run for overtime.");
        
        //Get Team 1's Team Name
        System.out.print("What is Team 1's team name?: ");
        team1Name = input.nextLine();
        
        //Get Team 2's Team Name
        System.out.print("\nWhat is Team 2's team name?: ");
        team2Name = input.nextLine();
        
        //Get teams total touchdowns and field goals for each quarter, then
        //calculate total score
        for (quarter = 1; quarter < 5; quarter++) { 
            //Ask for Team 1 Touchdowns and Field Goals
            System.out.printf("%nHow many Touchdowns did %s get in the %d quarter?: ", team1Name, quarter);
            team1TD = input.nextInt();
            team1TDTotal += team1TD; //Add values per quarter together
            
            System.out.printf("%nHow many Field Goals did %s get in the %d quarter?: ", team1Name, quarter);
            team1FG = input.nextInt();
            team1FGTotal += team1FG; //Add values per quarter together
            
            //Ask for Team 2 Touchdowns and Field Goals
            System.out.printf("%nHow many Touchdowns did %s get in the %d quarter?: ", team2Name, quarter);
            team2TD = input.nextInt();
            team2TDTotal += team2TD; //Add values per quarter together
            
            System.out.printf("%nHow many Field Goals did %s get in the %d quarter?: ", team2Name, quarter);
            team2FG = input.nextInt();
            team2FGTotal += team2FG; //Add values per quarter together
        }
        
        //Calculate Team 1 Final Score at the end of 4 Quarters
        team1Score = (team1TDTotal * touchDown) + (team1FGTotal * fieldGoal);
        
        //Calculate Team 2 Final Score at the end of 4 Quarters
        team2Score = (team2TDTotal * touchDown) + (team2FGTotal * fieldGoal);
        
        if (team1Score == team2Score) { //Run overtime to get a winner
            do {
                //Announce overtime and ask for touchdown and field goal counts
                System.out.println("\nDue to a tie in the scores, overtime will occur.");
                
                System.out.printf("%nHow many touchdowns did %s get in overtime?: ", team1Name);
                team1TDOvertime = input.nextInt();
                team1TDOvertimeTotal += team1TDOvertime;
                
                System.out.printf("%nHow many Field Goals did %s get in overtime?: ", team1Name);
                team1FGOvertime = input.nextInt();
                team1FGOvertimeTotal += team1FGOvertime;
                
                System.out.printf("%nHow many Touchdowns did %s get in overtime?: ", team2Name);
                team2TDOvertime = input.nextInt();
                team2TDOvertimeTotal += team1FGOvertime;
                
                System.out.printf("%nHow many Field Goals did %s get in overtime?: ", team2Name);
                team2FGOvertime = input.nextInt();
                team2FGOvertimeTotal += team2FGOvertime;
                
                //Calculate both final scores with added Overtime points
                team1Score = (team1TDTotal * touchDown) + (team1FGTotal * fieldGoal) + (team1TDOvertimeTotal * touchDown) + (team1FGOvertimeTotal * fieldGoal);
                team2Score = (team2TDTotal * touchDown) + (team2FGTotal * fieldGoal) + (team2TDOvertimeTotal * touchDown) + (team2FGOvertimeTotal * fieldGoal);
                
                
            } while (team1Score == team2Score);
        }
        
        if (team1Score > team2Score) {
            //Print the final scores and print the winning team name (Team 1)
            System.out.printf("%nFinal Score:%n%s: %d - %s: %d", team1Name, team1Score, team2Name, team2Score);
            System.out.printf("%n%s wins the game! Congratulations!", team1Name);
        }
        else {
            //Print the final score and print the winning team name (Team 2)
            System.out.printf("%nFinal score:%n%s: %d - %s: %d", team2Name, team2Score, team1Name, team1Score);
            System.out.printf("%n%s wins the game! Congratulations!", team2Name);
        }
    }  
}
