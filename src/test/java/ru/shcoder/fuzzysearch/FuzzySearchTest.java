package ru.shcoder.fuzzysearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FuzzySearchTest {

    private FuzzySearch searcher;
    private String[] sourceList;

    @Before
    public void setup() {
        searcher = new FuzzySearch();
        sourceList = new String[]{
                "Test",
                "Some",
                "Data for tests",
                "Some testers use some data for some tests",
                "Some testers use some data",
                "Some testers write some tests",
                "Self-test code",
                "Some data are used for some tests",
                "Some of the data could be aggregated and presented in tabular fashion",
                "They might be able to retrieve some of the data, -but it's going to take a while",
                "We can look at some of the data",
                "And to be certain, we need to do some tests",
                "I wrote some code for my mobile phone"
        };
    }

    @Test
    public void testSearchByWordsScoreStrategy() {
        String[] resultList = new String[]{
                "Some",
                "Some testers use some data",
                "Some testers write some tests",
                "Some data are used for some tests",
                "Some testers use some data for some tests",
                "We can look at some of the data",
                "I wrote some code for my mobile phone",
                "And to be certain, we need to do some tests",
                "Some of the data could be aggregated and presented in tabular fashion",
                "They might be able to retrieve some of the data, -but it's going to take a while"
        };
        WordsScoreStrategy strategty = new WordsScoreStrategy();
        strategty.setWeight(1);
        searcher.addScoreStrategy(strategty);
        assertArrayEquals(resultList, searcher.search(sourceList, "ia", 10));
    }

    @Test
    public void testSearchByStartsWithScoreStrategy() {
        String[] resultList = new String[]{
                "Some",
                "Some testers use some data",
                "Some testers write some tests",
                "Some data are used for some tests",
                "Some testers use some data for some tests",
                "We can look at some of the data",
                "I wrote some code for my mobile phone",
                "And to be certain, we need to do some tests",
                "Some of the data could be aggregated and presented in tabular fashion",
                "They might be able to retrieve some of the data, -but it's going to take a while"
        };
        StartsWithScoreStrategy strategty = new StartsWithScoreStrategy();
        strategty.setWeight(1);
        searcher.addScoreStrategy(strategty);
        assertArrayEquals(resultList, searcher.search(sourceList, "ia", 10));
    }

}
