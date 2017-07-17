package ru.shcoder.fuzzysearch;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class CharsScoreStrategyTest {

    private static double DELTA = 1e-3;

    @Test
    public void testWordsScoreStrategy() {
        CharsScoreStrategy strategy = new CharsScoreStrategy();
        strategy.setWeight(1);
        assertEquals(1, strategy.getScore("Some", "Some"), DELTA);
        assertEquals(0.44444, strategy.getScore("Some test", "Some"), DELTA);
        assertEquals(0.44444, strategy.getScore("Some", "Some test"), DELTA);
        assertEquals(0.15384, strategy.getScore("Some", "Some testers use some data"), DELTA);
        assertEquals(0.09756, strategy.getScore("Some", "Some testers use some data for some tests"), DELTA);
        assertEquals(0.75, strategy.getScore("Som", "Some"), DELTA);
    }

}
