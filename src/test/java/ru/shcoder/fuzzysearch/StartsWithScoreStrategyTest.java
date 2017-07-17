package ru.shcoder.fuzzysearch;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StartsWithScoreStrategyTest {

    private static double DELTA = 1e-15;

    @Test
    public void testWordsScoreStrategyTest() {
        StartsWithScoreStrategy strategy = new StartsWithScoreStrategy();
        strategy.setWeight(1);
        assertEquals(1, strategy.getScore("Some", "Some"), DELTA);
        assertEquals(0.5, strategy.getScore("Some test", "Some"), DELTA);
        assertEquals(0.5, strategy.getScore("Some", "Some test"), DELTA);
        assertEquals(0.2, strategy.getScore("Some", "Some testers use some data"), DELTA);
        assertEquals(0.125, strategy.getScore("Some", "Some testers use some data for some tests"), DELTA);
        assertEquals(0, strategy.getScore("Som", "Some"), DELTA);
    }

}
