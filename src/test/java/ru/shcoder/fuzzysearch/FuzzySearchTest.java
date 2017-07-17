package ru.shcoder.fuzzysearch;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

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
        WordsScoreStrategy strategy = new WordsScoreStrategy();
        strategy.setWeight(1);
        searcher.addScoreStrategy(strategy);
        assertArrayEquals(new String[]{
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
        }, searcher.search(sourceList, "Some", 10));
        assertArrayEquals(new String[]{
                "Some",
                "Some testers use some data",
                "Some testers use some data for some tests",
                "Test",
                "Data for tests"
        }, searcher.search(Arrays.copyOf(sourceList, 5), "Some", 10));
    }

    @Test
    public void testSearchByStartsWithScoreStrategy() {
        StartsWithScoreStrategy strategy = new StartsWithScoreStrategy();
        strategy.setWeight(1);
        searcher.addScoreStrategy(strategy);
        assertArrayEquals(new String[]{
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
        }, searcher.search(sourceList, "Some", 10));
        assertArrayEquals(new String[]{
                "Some",
                "Some testers use some data",
                "Some testers use some data for some tests",
                "Test",
                "Data for tests"
        }, searcher.search(Arrays.copyOf(sourceList, 5), "Some", 10));
    }

    @Test
    public void testSearchByCharsScoreStrategy() {
        CharsScoreStrategy strategy = new CharsScoreStrategy();
        strategy.setWeight(1);
        searcher.addScoreStrategy(strategy);
        assertArrayEquals(new String[]{
                "Some",
                "Self-test code",
                "Some testers use some data",
                "Test",
                "Some testers write some tests",
                "We can look at some of the data",
                "Data for tests",
                "Some data are used for some tests",
                "I wrote some code for my mobile phone",
                "Some testers use some data for some tests"
        }, searcher.search(sourceList, "Some", 10));
        assertArrayEquals(new String[]{
                "Some",
                "Some testers use some data",
                "Test",
                "Data for tests",
                "Some testers use some data for some tests"
        }, searcher.search(Arrays.copyOf(sourceList, 5), "Some", 10));
    }

    @Test
    public void testSearchByAllScoreStrategies() {
        WordsScoreStrategy wordsScoreStrategyInstance = new WordsScoreStrategy();
        StartsWithScoreStrategy startsWithScoreStrategyInstance = new StartsWithScoreStrategy();
        CharsScoreStrategy charsScoreStrategyInstance = new CharsScoreStrategy();
        wordsScoreStrategyInstance.setWeight(2);
        searcher.addScoreStrategy(wordsScoreStrategyInstance);
        startsWithScoreStrategyInstance.setWeight(5);
        searcher.addScoreStrategy(startsWithScoreStrategyInstance);
        charsScoreStrategyInstance.setWeight(3);
        searcher.addScoreStrategy(charsScoreStrategyInstance);
        assertArrayEquals(new String[]{
                "Some",
                "Some testers use some data",
                "Some testers write some tests",
                "Some data are used for some tests",
                "We can look at some of the data",
                "I wrote some code for my mobile phone",
                "Some testers use some data for some tests",
                "And to be certain, we need to do some tests",
                "Self-test code",
                "Some of the data could be aggregated and presented in tabular fashion"
        }, searcher.search(sourceList, "Some", 10));
        assertArrayEquals(new String[]{
                "Some",
                "Some testers use some data",
                "Some testers use some data for some tests",
                "Test",
                "Data for tests"
        }, searcher.search(Arrays.copyOf(sourceList, 5), "Some", 10));
    }

}
