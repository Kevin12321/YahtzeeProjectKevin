/**
 * Created by kadams16 on 12/17/15.
 */
import java.util.Scanner;
public class YahtzeeDriver
{
    /*
    1. Creates a new instance of the YahtzeeGame class
    2. Calls the playGame method on the Yahtzee object
    3. Asks user if they would like to play again
    4. When the user is done playing, prints the number of games played, min, max, and average score
    */
    public static void main(String [] args)
    {
        int score;
        YahtzeeGame myGame=new YahtzeeGame();
        System.out.println("Welcome to Kevin's Yahtzee!");
        score= myGame.playGame();

        System.out.println("Would you like to play again? (y/n): ");
        Scanner s = new Scanner(System.in);
        String answer = s.nextLine();

        int numGames = 1;
        int min = score;
        int max = score;
        double avgScore = (1.0*score) / (1.0*numGames);

        while(answer.equals("y")) {
            myGame = new YahtzeeGame();
            int score1 = myGame.playGame();
            score += score1;
            if(score1 > max) {
                max = score1;
            }
            if(score1 < min) {
                min = score1;
            }
            numGames++;
            avgScore = score/numGames;
            System.out.println("Would you like to play again? (y/n): ");
            answer = s.nextLine();
        }

        System.out.println("Number of games played: " + numGames);
        System.out.println("Max score: " + max);
        System.out.println("Min score: " + min);
        System.out.println("Average score: " + avgScore);














    }
}
