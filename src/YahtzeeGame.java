/**
 * Created by kadams16 on 12/17/15.
 */
import java.util.Scanner;

public class YahtzeeGame
{
    /* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
    which should be set to six (the number of sides on a yahtzee die) */
    private YahtzeeDie die1;
    private YahtzeeDie die2;
    private YahtzeeDie die3;
    private YahtzeeDie die4;
    private YahtzeeDie die5;
    private YahtzeeScorecard sc;
    private static final int NUM_SIDES = 6;
    private Scanner s = new Scanner(System.in);


    /* initializes the dice and scoreboard */
    public YahtzeeGame()
    {
        die1 = new YahtzeeDie(NUM_SIDES);
        die2 = new YahtzeeDie(NUM_SIDES);
        die3 = new YahtzeeDie(NUM_SIDES);
        die4 = new YahtzeeDie(NUM_SIDES);
        die5 = new YahtzeeDie(NUM_SIDES);
        sc = new YahtzeeScorecard();
    }

    /* check to see if the game is over, and while the game is not over call the method takeTurn()
    once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
    final scorecard and return the grand total */
    public int playGame()
    {
        die1.unfreezeDie(); die2.unfreezeDie(); die3.unfreezeDie(); die4.unfreezeDie(); die5.unfreezeDie();
        for(int i = 0; i < 13; i++) {
            takeTurn();
        }
        sc.printScoreCard();
        return sc.getGrandTotal();
    }

    /*  1. call rollDice()
    2. call printDice()
    3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
       If they are not satisfied continue, otherwise call markScore()
    4. call chooseFrozen()
    5. call rollDice()
    6. call printDice()
    7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
       If they are not satisfied continue, otherwise call markScore()
    8. call chooseFrozen()
    9. call rollDice()
    10. call printDice()
    11. call markScore()
    */
    private void takeTurn()
    {
        String ans = new String();

        rollDice();
        printDice();
        for(int i = 0; i < 2 && !(ans.equals("y")); i++) {

            System.out.println("Are you satisfied with your roll? (y/n): ");
            ans = s.nextLine();
            if(ans.equals("n")) {
                chooseFrozen();
                rollDice();
                printDice();
            } else if(ans.equals("y")){
                markScore();
            }
        }
        if(ans.equals("n")) {
            markScore();
        }

    }

    /* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
    private void rollDice()
    {
        if(die1.isFrozen() == false) {
            die1.rollDie(); }
        if(die2.isFrozen() == false) {
            die2.rollDie(); }
        if(die3.isFrozen() == false) {
            die3.rollDie(); }
        if(die4.isFrozen() == false) {
            die4.rollDie(); }
        if(die5.isFrozen() == false) {
            die5.rollDie(); }
        die1.unfreezeDie(); die2.unfreezeDie(); die3.unfreezeDie(); die4.unfreezeDie(); die5.unfreezeDie();
    }

    /* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
    private void chooseFrozen()
    {
        System.out.println("Which dice would you like to freeze? (Seperate die number by 1 dash, no spaces.): ");
        String freeze = s.nextLine();
        if(freeze.indexOf('1') != -1) {
            die1.freezeDie();
        }
        if(freeze.indexOf('2') != -1) {
            die2.freezeDie();
        }
        if(freeze.indexOf('3') != -1) {
            die3.freezeDie();
        }
        if(freeze.indexOf('4') != -1) {
            die4.freezeDie();
        }
        if(freeze.indexOf('5') != -1) {
            die5.freezeDie();
        }

    }

    /* Should print the value of all five dice separated by a tab (\t) to the console */
    private void printDice()
    {
        System.out.println("" + die1.getValue() + "\t" + die2.getValue() + "\t" + die3.getValue()+"\t"+ die4.getValue()+ "\t" + die5.getValue());
    }

    /* 1. Print a scoreboard
       2. Ask the user where they would like to mark their score.
       3. Call appropriate function
       4. If false is returned the user entered an invalid number, so ask the user to try again */
    private void markScore()
    {
        boolean success = false;
        while(success == false) {
            Scanner s = new Scanner(System.in);
            sc.printScoreCard();
            System.out.println("Where Would you like to mark your score?: ");
            System.out.println("1 for ones");
            System.out.println("2 for twos");
            System.out.println("3 for threes");
            System.out.println("4 for fours");
            System.out.println("5 for fives");
            System.out.println("6 for sixes");
            System.out.println("7 for three of a kind");
            System.out.println("8 for four of a kind");
            System.out.println("9 for full house");
            System.out.println("10 for small straight");
            System.out.println("11 for large straight");
            System.out.println("12 for yahtzee");
            System.out.println("13 for chance");
            int mark = s.nextInt();
            int mark2 = 0;
            while(mark2 > 13 || mark2 <1) {
                mark2= mark;
                if(mark==1){
                    success = sc.markOnes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==2) {
                    success = sc.markTwos(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==3) {
                    success = sc.markThrees(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==4){
                    success = sc.markFours(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==5){
                    success = sc.markFives(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==6){
                    success = sc.markSixes(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                }else if(mark==7){
                    success = sc.markThreeOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==8){
                    success = sc.markFourOfAKind(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                }else if(mark==9) {
                    success = sc.markFullHouse(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==10){
                    success = sc.markSmallStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==11){
                    success = sc.markLargeStraight(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==12){
                    success = sc.markYahtzee(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                } else if(mark==13){
                    success = sc.markChance(die1.getValue(), die2.getValue(), die3.getValue(), die4.getValue(), die5.getValue());

                }else{
                    System.out.println("Please enter a valid number.");
                }

            }
        }

    }


}