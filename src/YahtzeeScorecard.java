/**
 * Created by kadams16 on 12/17/15.
 */
public class YahtzeeScorecard {
    /* instance data given */
    private int ones;
    private int twos;
    private int threes;
    private int fours;
    private int fives;
    private int sixes;
    private int threeKind;
    private int fourKind;
    private int fiveKind;
    private int chance;
    private int fullHouse;
    private int smStraight;
    private int lgStraight;
    private boolean bonus;

    /* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
    public YahtzeeScorecard() {
        ones = -1;
        twos = -1;
        threes = -1;
        fours = -1;
        fives = -1;
        sixes = -1;
        threeKind = -1;
        fourKind = -1;
        fiveKind = -1;
        chance = -1;
        fullHouse = -1;
        smStraight = -1;
        lgStraight = -1;
        bonus = false;
    }

    /* 1. If the field is already full, return false
       2. Set data value ones equal to number of ones rolled multiplied by one.
       3. Update the bonus (call updateBonus())
       4. Return true   */
    public boolean markOnes(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        if (ones == -1) {
            if (die1 == 1) {
                count++;
            }
            if (die2 == 1) {
                count++;
            }
            if (die3 == 1) {
                count++;
            }
            if (die4 == 1) {
                count++;
            }
            if (die5 == 1) {
                count++;
            }
            this.ones = count;
            updateBonus();
            return true;
        } else {
            return false;
        }
    }


    /* 1. If the field is already full, return false
       2. Set data value twos equal to number of twos rolled multiplied by two.
       3. Update the bonus (call updateBonus())
       4. Return true   */
    public boolean markTwos(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        if (twos == -1) {
            if (die1 == 2) {
                count++;
            }
            if (die2 == 2) {
                count++;
            }
            if (die3 == 2) {
                count++;
            }
            if (die4 == 2) {
                count++;
            }
            if (die5 == 2) {
                count++;
            }
            this.twos = count * 2;
            updateBonus();
            return true;
        } else {
            return false;
        }
    }

    /* 1. If the field is already full, return false
       2. Set data value threes equal to number of threes rolled multiplied by three.
       3. Update the bonus (call updateBonus())
       4. Return true  */
    public boolean markThrees(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        if (threes == -1) {
            if (die1 == 3) {
                count++;
            }
            if (die2 == 3) {
                count++;
            }
            if (die3 == 3) {
                count++;
            }
            if (die4 == 3) {
                count++;
            }
            if (die5 == 3) {
                count++;
            }
            this.threes = count * 3;
            updateBonus();
            return true;
        } else {
            return false;
        }
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value fours equal to number of fours rolled multiplied by four.
       3. Update the bonus (call updateBonus())
       4. Returns true   */
    public boolean markFours(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        if (fours == -1) {
            if (die1 == 4) {
                count++;
            }
            if (die2 == 4) {
                count++;
            }
            if (die3 == 4) {
                count++;
            }
            if (die4 == 4) {
                count++;
            }
            if (die5 == 4) {
                count++;
            }
            this.fours = count * 4;
            updateBonus();
            return true;
        } else {
            return false;
        }
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value fives equal to number of fives rolled multiplied by five.
       3. Update the bonus (call updateBonus())
       4. Returns true   */
    public boolean markFives(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        if (fives == -1) {
            if (die1 == 5) {
                count++;
            }
            if (die2 == 5) {
                count++;
            }
            if (die3 == 5) {
                count++;
            }
            if (die4 == 5) {
                count++;
            }
            if (die5 == 5) {
                count++;
            }
            this.fives = count * 5;
            updateBonus();
            return true;
        } else {
            return false;
        }
    }

    /* 1. If the field is already full, the method returns false
       2. Sets data value sixes equal to number of sixes rolled multiplied by six.
       3. Update the bonus (call updateBonus())
       4. Returns true */
    public boolean markSixes(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        if (sixes == -1) {
            if (die1 == 6) {
                count++;
            }
            if (die2 == 6) {
                count++;
            }
            if (die3 == 6) {
                count++;
            }
            if (die4 == 6) {
                count++;
            }
            if (die5 == 6) {
                count++;
            }
            this.sixes = count * 6;
            updateBonus();
            return true;
        } else {
            return false;
        }
    }

    /*  1. If the field is already full, return false
    2. Check to see if there are actually three of the same value.
       If there are, set the data value threeKind to the value of all five dice.
       If there aren't set the value to 0.
           (Hint: use YahtzeeSortDice class!)
        4. Return true   */

    public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        int num = 0;
        if (threeKind == -1) {
            for (int i = 1; i < 7 && count < 3; i++) {
                if (die1 == i) {
                    count++;
                }
                if (die2 == i) {
                    count++;
                }
                if (die3 == i) {
                    count++;
                }
                if (die4 == i) {
                    count++;
                }
                if (die5 == i) {
                    count++;
                }
                if (count < 3) {
                    count = 0;
                    num = i;
                }
            }
            if (count >= 3) {
                this.threeKind = die1 + die2 + die3 + die4 + die5;
            } else {
                this.threeKind = 0;
            }
            return true;
        } else {
            return false;
        }

    }

    /*  1. If the field is already full, return false
    2. Check to see if there are actually four of the same value.
       If there are, set the data value fourKind to the value of all five dice.
       If there aren't set the value to 0;
       (Hint: use YahtzeeSortDice class!)
    4. Return true  */
    public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        int num = 0;
        if (fourKind == -1) {
            for (int i = 1; i < 7 && count < 4; i++) {
                if (die1 == i) {
                    count++;
                }
                if (die2 == i) {
                    count++;
                }
                if (die3 == i) {
                    count++;
                }
                if (die4 == i) {
                    count++;
                }
                if (die5 == i) {
                    count++;
                }
                if (count < 4) {
                    count = 0;
                    num = i;
                }
            }
            if (count >= 4) {
                this.fourKind = die1 + die2 + die3 + die4 + die5;
            } else {
                this.fourKind = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    /* 1. If the field is already full, return false
       2. Check to see if there are actually three die with the same value, and two with another value.
          If there are, set the data value fullHouse to 25.
          If there arent set the value to 0.
          (Hint: Use YahtzeeSortedDice class!)
          3. Return true   */
    public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5) {
        YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
        if (fullHouse == -1) {
            fullHouse = 0;
            if (((sort.getFirst() == sort.getSecond()) && (sort.getThird() == sort.getFourth()) && (sort.getThird() == sort.getFifth()))) {
                fullHouse = 25;
            }
            if (((sort.getFirst() == sort.getSecond()) && (sort.getFirst() == sort.getThird()) && (sort.getFourth() == sort.getFifth()))) {
                fullHouse = 25;
            }
            return true;
        } else {
            return false;
        }
    }

    /*  1. If the field is already full, return false
    2. Check to see if there are actually four consecutive dice numbers.
       If there are, set the data value smStraight to 30.
       If there arent set the value to 0.
       (Hint: Use YahtzeeSortedDice class)
    4. Return true  */
    public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5) {
        YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
        if (smStraight == -1) {
            if ((sort.getFirst() + 1 == sort.getSecond()) && (sort.getSecond() + 1 == sort.getThird()) && (sort.getThird() + 1 == sort.getFourth())) {
                smStraight = 30;
            }
            if ((sort.getSecond() + 1 == sort.getThird()) && (sort.getThird() + 1 == sort.getFourth()) && (sort.getFourth() + 1 == sort.getFifth())) {
                smStraight = 30;
            }
            if ((sort.getFirst() + 1 == sort.getSecond()) && (sort.getSecond() + 1 == sort.getThird()) && (sort.getThird() + 1 == sort.getFifth())) {
                smStraight = 30;
            }
            if ((sort.getFirst() + 1 == sort.getThird()) && (sort.getThird() + 1 == sort.getFourth()) && (sort.getFourth() + 1 == sort.getFifth())) {
                smStraight = 30;
            }
            return true;
        } else {
            return false;
        }
    }

    /*  1. If the field is already full, return false
    2. Check to see if there are actually five consecutive dice numbers.
       If there are, set the data value lgStraight to 40.
       If there aren't set the value to 0;
       (Hint: use YahtzeeSortDice class!)
    3. Return true  */
    public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5) {
        YahtzeeSortDice sort = new YahtzeeSortDice(die1, die2, die3, die4, die5);
        if (lgStraight == -1) {
            if ((sort.getSecond() == sort.getFirst() + 1) && (sort.getThird() == sort.getSecond() + 1) && (sort.getFourth() == sort.getThird() + 1) && (sort.getFifth() == sort.getFourth() + 1)) {
                lgStraight = 40;
            } else {
                lgStraight = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    /* 1. If the field is already full, return false
       2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren't set the value to 0;
          3. Return true   */
    public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5) {
        int count = 0;
        int num = 0;
        if (fiveKind == -1) {
            for (int i = 1; i < 7 && count < 5; i++) {
                if (die1 == i) {
                    count++;
                }
                if (die2 == i) {
                    count++;
                }
                if (die3 == i) {
                    count++;
                }
                if (die4 == i) {
                    count++;
                }
                if (die5 == i) {
                    count++;
                }
                if (count < 5) {
                    count = 0;
                    num = i;
                }
            }
            if (count == 5) {
                this.fiveKind = 50;
            } else {
                this.fiveKind = 0;
            }
            return true;
        } else {
            return false;
        }
    }

    /* 1. If the field is already full, return false
       2. Set the data value chance to the value of all five dice.
       3. Return true  */
    public boolean markChance(int die1, int die2, int die3, int die4, int die5) {
        if (chance == -1) {
            chance = die1 + die2 + die3 + die4 + die5;
            return true;
        } else {
            return false;
        }
    }

    /*  1. If the bonus has already been assigned, do nothing
    2. If the upper section's total is 63 or greater, set the data value bonus to true */
    private void updateBonus() {
        if (bonus == false) {
            if ((ones + twos + threes + fours + fives + sixes) >= 63) {
                bonus = true;
            }
        }
    }

    /*  returns the upper total, remember incompletes (-1s) should not be factored in! */
    public int getUpperTotal() {
        int uptotal = 0;
        if (ones != -1) {
            uptotal += ones;
        }
        if (twos != -1) {
            uptotal += twos;
        }
        if (threes != -1) {
            uptotal += threes;
        }
        if (fours != -1) {
            uptotal += fours;
        }
        if (fives != -1) {
            uptotal += fives;
        }
        if (sixes != -1) {
            uptotal += sixes;
        }
        if (bonus == true) {
            uptotal += 35;
        }
        return uptotal;

    }

    /*  returns the lower total, remember incompletes (-1s) should not be factored in! */
    public int getLowerTotal() {
        int lowtotal = 0;
        if (threeKind != -1) {
            lowtotal += threeKind;
        }
        if (fourKind != -1) {
            lowtotal += fourKind;
        }
        if (fiveKind != -1) {
            lowtotal += fiveKind;
        }
        if (fullHouse != -1) {
            lowtotal += fullHouse;
        }
        if (smStraight != -1) {
            lowtotal += smStraight;
        }
        if (lgStraight != -1) {
            lowtotal += lgStraight;
        }
        if (chance != -1) {
            lowtotal += chance;
        }
        return lowtotal;
    }

    /*  returns the grand total, remember incompletes (-1s) should not be factored in! */
    public int getGrandTotal() {
        int gtotal = 0;
        if (getUpperTotal() != -1) {
            gtotal += getUpperTotal();
        }
        if (getLowerTotal() != -1) {
            gtotal += getLowerTotal();
        }
        return gtotal;
    }

    /* Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
    Sample:
    **********************************
    *       Yahtzee Score Card  *
    *   `     *
    *  Ones: __  *
    *  Twos: __  *
    *  Threes: __  *
    *  Fours: __  *
    *  Fives: 25  *
    *  Sixes: __  *
    *  *
    * Upper Bonus:  0  *
    *  Upper Total:    25  *
    *  *
    * 3 of Kind: __  *
    *  4 of Kind: __  *
    *  Full House: 25  *
    *  Sm Straight: __  *
    *  Lg  Straight: __  *
    *  Yahtzee:     0  *
    *  Chance: __  *
    *  *
    *  Lower Total: 25  *
    *  *
    *  Grand Total: 50  *
    **********************************
    already implemented
    */
    public void printScoreCard() {
        System.out.println();
        System.out.println("*********************************");
        System.out.println("*      Yahtzee Score Card       *");
        System.out.println("*                               *");
        System.out.print("*  Ones:\t\t");
        if (ones == -1) System.out.print("__");
        else System.out.print(ones);
        System.out.println("\t*");
        System.out.print("*  Twos:\t\t");
        if (twos == -1) System.out.print("__");
        else System.out.print(twos);
        System.out.println("\t*");
        System.out.print("*  Threes:\t\t");
        if (threes == -1) System.out.print("__");
        else System.out.print(threes);
        System.out.println("\t*");
        System.out.print("*  Fours:\t\t");
        if (fours == -1) System.out.print("__");
        else System.out.print(fours);
        System.out.println("\t*");
        System.out.print("*  Fives:\t\t");
        if (fives == -1) System.out.print("__");
        else System.out.print(fives);
        System.out.println("\t*");
        System.out.print("*  Sixes:\t\t");
        if (sixes == -1) System.out.print("__");
        else System.out.print(sixes);
        System.out.println("\t*");
        System.out.println("*\t\t\t\t*");
        System.out.print("*  Upper Bonus:\t\t");
        if (bonus) System.out.print("35");
        else System.out.print("0");
        System.out.println("\t*");
        System.out.print("*  Upper Total:\t\t");
        System.out.print(this.getUpperTotal());
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  3 of Kind:\t\t");
        if (threeKind == -1) System.out.print("__");
        else System.out.print(threeKind);
        System.out.println("\t*");
        System.out.print("*  4 of Kind:\t\t");
        if (fourKind == -1) System.out.print("__");
        else System.out.print(fourKind);
        System.out.println("\t*");
        System.out.print("*  Full House:\t\t");
        if (fullHouse == -1) System.out.print("__");
        else System.out.print(fullHouse);
        System.out.println("\t*");
        System.out.print("*  Sm Straight:\t\t");
        if (smStraight == -1) System.out.print("__");
        else System.out.print(smStraight);
        System.out.println("\t*");
        System.out.print("*  Lg Straight:\t\t");
        if (lgStraight == -1) System.out.print("__");
        else System.out.print(lgStraight);
        System.out.println("\t*");
        System.out.print("*  Yahtzee:\t\t");
        if (fiveKind == -1) System.out.print("__");
        else System.out.print(fiveKind);
        System.out.println("\t*");
        System.out.print("*  Chance:\t\t");
        if (chance == -1) System.out.print("__");
        else System.out.print(chance);
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  Lower Total:\t\t");
        System.out.print(this.getLowerTotal());
        System.out.println("\t*");
        System.out.println("*                               *");
        System.out.print("*  Grand Total:\t\t");
        System.out.print(this.getGrandTotal());
        System.out.println("\t*");
        System.out.println("**********************************");
        System.out.println();
    }

}
