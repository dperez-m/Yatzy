package cd.dperez;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class YatzyTest {

    @Test
    public void testChance() {
        assertEquals(15, Yatzy.chance(2,3,4,5,1));
        assertEquals(19, Yatzy.chance(3,3,6,6,1));
        assertEquals(5, Yatzy.chance(1,1,1,1,1));
    }

    @Test
    public void testYatzy() {
        assertEquals(50, Yatzy.yatzy(4,4,4,4,4));
        assertEquals(50, Yatzy.yatzy(6,6,6,6,6));
        assertEquals(0, Yatzy.yatzy(6,6,6,6,3));
    }

    @Test
    public void testOnes() {
        assertEquals(1, Yatzy.ones(1,2,3,4,5));
        assertEquals(2, Yatzy.ones(1,2,1,4,5));
        assertEquals(0, Yatzy.ones(6,2,2,4,5));
        assertEquals(4, Yatzy.ones(1,2,1,1,1));
    }

    @Test
    public void testTwos() {
        assertEquals(4, Yatzy.twos(1,2,3,2,6));
        assertEquals(10, Yatzy.twos(2,2,2,2,2));
        assertEquals(0, Yatzy.twos(1, 4, 5, 3, 6));
        assertEquals(8, Yatzy.twos(2, 2, 4, 2, 2));
    }

    @Test
    public void testThrees() {
        assertEquals(6, Yatzy.threes(1,2,3,2,3));
        assertEquals(12, Yatzy.threes(2,3,3,3,3));
        assertEquals(15, Yatzy.threes(3,3,3,3,3));
        assertEquals(0, Yatzy.threes(4,1,6,5,2));
    }

    @Test
    public void testFours() {
        assertEquals(12, Yatzy.fours(4,4,4,5,5));
        assertEquals(8, Yatzy.fours(4,4,5,5,5));
        assertEquals(4, Yatzy.fours(4,5,5,5,5));
        assertEquals(0, Yatzy.fours(1,2,3,5,6));
        assertEquals(20, Yatzy.fours(4,4,4,4,4));
    }

    @Test
    public void testFives() {
        assertEquals(10, Yatzy.fives(4,4,4,5,5));
        assertEquals(15, Yatzy.fives(4,4,5,5,5));
        assertEquals(25, Yatzy.fives(5,5,5,5,5));
        assertEquals(0, Yatzy.fives(1,2,3,4,6));
    }

    @Test
    public void testSixes() {
        assertEquals(0, Yatzy.sixes(4,4,4,5,5));
        assertEquals(6, Yatzy.sixes(4,4,6,5,5));
        assertEquals(18, Yatzy.sixes(6,5,6,6,5));
        assertEquals(30, Yatzy.sixes(6,6,6,6,6));
    }

    @Test
    public void testPair() {
        assertEquals(6, Yatzy.pair(3,4,3,5,6));
        assertEquals(10, Yatzy.pair(5,3,3,3,5));
        assertEquals(12, Yatzy.pair(5,3,6,6,5));
        assertEquals(0,Yatzy.pair(1,2,3,4,5));
    }

    @Test
    public void testDoublePair() {
        assertEquals(16, Yatzy.doublePair(3,3,5,4,5));
        assertEquals(16, Yatzy.doublePair(3,3,5,5,5));
        assertEquals(0, Yatzy.doublePair(1,1,2,3,4));
    }

    @Test
    public void testThreeOfAKind()
    {
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,4,5));
        assertEquals(15, Yatzy.threeOfAKind(5,3,5,4,5));
        assertEquals(9, Yatzy.threeOfAKind(3,3,3,3,5));
        assertEquals(0, Yatzy.threeOfAKind(2,2,3,3,5));
        assertEquals(12, Yatzy.threeOfAKind(4,4,4,4,4));
    }

    @Test
    public void testFourOfAKind() {
        assertEquals(12, Yatzy.fourOfAKind(3,3,3,3,5));
        assertEquals(20, Yatzy.fourOfAKind(5,5,5,4,5));
        assertEquals(12, Yatzy.fourOfAKind(3,3,3,3,3));
        assertEquals(0, Yatzy.fourOfAKind(3,4,3,3,1));
    }

    @Test
    public void testSmallStraight() {
        assertEquals(15, Yatzy.smallStraight(1,2,3,4,5));
        assertEquals(15, Yatzy.smallStraight(2,3,4,5,1));
        assertEquals(0, Yatzy.smallStraight(1,2,2,4,5));
    }

    @Test
    public void testLargeStraight() {
        assertEquals(20, Yatzy.largeStraight(6,2,3,4,5));
        assertEquals(20, Yatzy.largeStraight(2,3,4,5,6));
        assertEquals(0, Yatzy.largeStraight(1,2,2,4,5));
    }

    @Test
    public void testFullHouse() {
        assertEquals(18, Yatzy.fullHouse(6,2,2,2,6));
        assertEquals(0, Yatzy.fullHouse(2,3,4,5,6));
        assertEquals(0, Yatzy.fullHouse(2,2,2,2,2));
    }
}
