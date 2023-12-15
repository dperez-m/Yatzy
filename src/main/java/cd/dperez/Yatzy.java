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

    public static int threeOfAKind(int... dice) {
        int[] counts = new int[6];

       for (int die : dice){
           counts[die - 1]++;
       }

        for (int i = 0; i < 6; i++)
            if (counts[i] >= 3)
                return (i+1) * 3;
        return 0;
    }

    public static int fourOfAKind(int... dice) {
        int[] counts = new int[6];

        for (int die : dice){
            counts[die - 1]++;
        }

        for (int i = 0; i < 6; i++)
            if (counts[i] >= 4)
                return (i+1) * 4;
        return 0;
    }

    public static int smallStraight(int... dice) {
        final int[] SMALL_STRAIGHT = {1, 2, 3, 4, 5};

        Arrays.sort(dice);
        if (Arrays.equals(dice, SMALL_STRAIGHT))
            return 15;
        return 0;
    }

    public static int largeStraight(int... dice) {
        final int[] LARGE_STRAIGHT = {2, 3, 4, 5, 6};

        Arrays.sort(dice);
        if (Arrays.equals(dice, LARGE_STRAIGHT))
            return 20;
        return 0;
    }

    public static int fullHouse(int... dice) {
        int[] counts = new int[6];
        boolean pair = false;
        int pairVal = 0;
        boolean threeEquals = false;
        int threeEqualsVal = 0;

        for (int die : dice){
            counts[die - 1]++;
        }

        for (int i = 0; i != 6; i += 1) {
            if (counts[i] == 2) {
                pair = true;
                pairVal = i + 1;
            }
            if (counts[i] == 3) {
                threeEquals = true;
                threeEqualsVal = i + 1;
            }
        }

        if (pair && threeEquals)
            return pairVal * 2 + threeEqualsVal * 3;
        else
            return 0;
    }
}
