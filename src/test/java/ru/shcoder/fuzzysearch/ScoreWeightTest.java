package ru.shcoder.fuzzysearch;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ScoreWeightTest {

    @Test
    public void testScoreWeight() {
        ScoreWeight instance = new ScoreWeight();
        instance.setWeight(1);
        assertEquals(1, instance.getWeight());
        instance.setWeight(2);
        assertEquals(2, instance.getWeight());
    }

}
