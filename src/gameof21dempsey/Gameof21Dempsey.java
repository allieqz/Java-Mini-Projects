package gameof21dempsey;
import java.util.Scanner;
/**
 * This program simulates the Game of 21
 * @author Allie
 */
public class Gameof21Dempsey 
{
    public static void main(String[] args) 
    {
        final int die1_sides = 6; // Number of sides for die 1
        final int die2_sides = 6; // Number of sides for die 2
        
        // Creating four instances of the Die class - two for each player
        Die die1p = new Die(die1_sides); // For user-player
        Die die2p = new Die(die2_sides); // For user-player
        Die die1c = new Die(die1_sides); // For computer
        Die die2c = new Die(die2_sides); // For computer
        
        // Starting the game
        System.out.println("Let's start the game!");     
        System.out.println ("Rolling the dice for computer....");
        System.out.println ("Rolling the dice for you....");
        
        // Initial roll for computer
        die1c.getValue();
        die2c.getValue();
        
        // Printing out initial roll for the user-player
        System.out.println("Your first roll is: " + die1p.getValue() + "  " +
                    die2p.getValue());    
        
        // Starting the accumultors for the total scores
        int sumPlayer = die1p.getValue() + die2p.getValue();
        int sumComp = die1c.getValue() + die2c.getValue();
        
        Scanner keyboard = new Scanner(System.in);
        // Asking the user-player whether he or she wants to continue
        System.out.println("Would you like to play another round? Enter Y for YES " +
                " or N for NO");
        String answer = keyboard.nextLine();
        
        // Running the loop while the user-player agrees to continue
        while (answer.equals("Y") || answer.equals("y"))
        {
            // First, rolling for computer
            die1c.roll();
            die2c.roll();
            sumComp += die1c.getValue() + die2c.getValue();
            
            // Checking whether computer went over 21
            if (sumComp >= 22)
                break; // Loops discontinues
            
            // Second, rolling for user-player
            die1p.roll();
            die2p.roll();
            
            // Printing out for user-player
            System.out.println("This round you've got: " + die1p.getValue() + "  " +
                    die2p.getValue());
            sumPlayer += die1p.getValue() + die2p.getValue();
            
            // Checking whether user-player went over 21
            if (sumPlayer >= 22)
                break; // Loops discontinues
            else
            {
                System.out.println("Would you like to play another round? Enter Y for YES " +
                " or N for NO");
                answer = keyboard.nextLine();
            }
        }
        
        // When the user-player decides to stop the game
        if ((answer.equals("N") || answer.equals("n")) && (sumPlayer < 22 && sumComp < 22))
        {    
            System.out.println("Your total score is: " + sumPlayer);
            System.out.println("Computer's total score is: " + sumComp);
            if (sumPlayer > sumComp)
                System.out.println("You won!");
            if (sumPlayer < sumComp)
                System.out.println("You lost!");
            if (sumPlayer == sumComp)
                System.out.println("It's a tie!");
        }
        
        // Printing results when computer went over 21 before the user-player
        if ((answer.equals("Y") || answer.equals("y")) && sumComp > 21)
        {
            System.out.println("You won! Computer went over 21!" +
                    " Computer's total score is: " + sumComp);
            System.out.println("Your total score is: " + sumPlayer);
        }
        
        // Printing results when the user-player went over 21 before the computer
        if ((answer.equals("Y") || answer.equals("y")) && sumPlayer > 21)
        {
            System.out.println("Sorry, you lost! You went over 21." +
                    " Your total score is: " +
                    sumPlayer); 
            System.out.println("Computer's total score is: " + sumComp);
        }
    }    
}
