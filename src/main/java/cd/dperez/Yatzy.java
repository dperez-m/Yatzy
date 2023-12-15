package cd.dperez;

import java.util.Arrays;
import java.util.HashSet;

public class Yatzy {

    public static int chance(int... dice) {
       return Arrays.stream(dice).sum();
    }

    public static int yatzy(int... dice) {
       return Arrays.stream(dice).distinct().count() <= 1 ? 50 : 0;
    }

    public static int ones(int... dice) {
        return Math.toIntExact(Arrays.stream(dice).filter(die -> die == 1).count());
    }

    public static int twos(int... dice) {
        int twosCount = Math.toIntExact(Arrays.stream(dice).filter(die -> die == 2).count());
        return twosCount * 2;
    }

    public static int threes(int... dice) {
        int threesCount = Math.toIntExact(Arrays.stream(dice).filter(die -> die == 3).count());
        return threesCount * 3;
    }

    public static int fours(int... dice) {
        int foursCount = Math.toIntExact(Arrays.stream(dice).filter(die -> die == 4).count());
        return foursCount * 4;
    }

    public static int fives(int... dice) {
        int fivesCount = Math.toIntExact(Arrays.stream(dice).filter(die -> die == 5).count());
        return fivesCount * 5;
    }

    public static int sixes(int... dice) {
        int sixesCount = Math.toIntExact(Arrays.stream(dice).filter(die -> die == 6).count());
        return sixesCount * 6;
    }

    public static int pair(int... dice) {
        Arrays.sort(dice);
        for (int i = dice.length; i > 1; i--){
            if (dice[i - 1] == dice[i - 2]){
                return dice[i - 1] * 2;
            }
        }
        return 0;
    }

    public static int doublePair(int... dice) {
        int pairs = 0;
        int score = 0;
        int prev = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        Arrays.sort(dice);
        for (int i = dice.length - 1; i >= 0; i--){
            if (!set.add(dice[i]) && pairs <= 2 && dice[i] != prev){
                pairs++;
                score += dice[i];
                prev = dice[i];
            }
        }
        if (pairs == 2)
            return score * 2;
        return 0;

    }

    public static int four_of_a_kind(int... dice) {
        int[] counts = new int[6];

        for (int die : dice){
            counts[die - 1]++;
        }

        for (int i = 0; i < 6; i++)
            if (counts[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int three_of_a_kind(int... dice) {
        int[] counts = new int[6];

       for (int die : dice){
           counts[die - 1]++;
       }

        for (int i = 0; i < 6; i++)
            if (counts[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int smallStraight(int... dice) {
        final int[] SMALL_STRAIGHT = {1, 2, 3, 4, 5};

        Arrays.sort(dice);
        if (Arrays.equals(dice, SMALL_STRAIGHT))
            return 15;
        return 0;
    }

    public static int largeStraight(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;
        if (tallies[1] == 1 &&
                tallies[2] == 1 &&
                tallies[3] == 1 &&
                tallies[4] == 1
                && tallies[5] == 1)
            return 20;
        return 0;
    }

    public static int fullHouse(int d1, int d2, int d3, int d4, int d5)
    {
        int[] tallies;
        boolean _2 = false;
        int i;
        int _2_at = 0;
        boolean _3 = false;
        int _3_at = 0;




        tallies = new int[6];
        tallies[d1-1] += 1;
        tallies[d2-1] += 1;
        tallies[d3-1] += 1;
        tallies[d4-1] += 1;
        tallies[d5-1] += 1;

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 2) {
                _2 = true;
                _2_at = i+1;
            }

        for (i = 0; i != 6; i += 1)
            if (tallies[i] == 3) {
                _3 = true;
                _3_at = i+1;
            }

        if (_2 && _3)
            return _2_at * 2 + _3_at * 3;
        else
            return 0;
    }
}
