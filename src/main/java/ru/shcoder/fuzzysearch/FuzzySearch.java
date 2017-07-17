package ru.shcoder.fuzzysearch;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.lang.Double;

/**
 * <h1>Class FuzzySearch</h1>
 * Search strings by specific strategies.
 *
 * @author  Vasiliy Shilov (https://github.com/shcoder-ru)
 * @version 1.0
 * @since   2017-07-17
 */
public class FuzzySearch implements FuzzySearchable {

    private List<ScoreStrategy> strategiesList = new ArrayList<>();
    /**
     * Add Similarity calculation strategy
     * @param strategy Similarity calculation strategy for two strings
     */
    public void addScoreStrategy(ScoreStrategy strategy) {
        strategiesList.add(strategy);
    }

    /**
     * Search for strings by specific strategies
     * @param list Source list of strings
     * @param input Search query string
     * @param limit Maximum number of results
     * @return Sorted list of strings
     */
    public String[] search(String[] list, String input, int limit) {
        String[] sorted = Arrays.copyOf(list, list.length);
        Arrays.sort(sorted, (str1, str2) -> fuzzyCompare(str1, str2, input));
        return Arrays.copyOf(sorted, limit > sorted.length ? sorted.length : limit);
    }

    /**
     * Get similarity score of list item and input
     * @param text - Source list item
     * @param input - Search query string
     * @return Average score
     */
    private double getSimilarityScore(String text, String input) {
        int currentWeight;
        long totalWeight = 0;
        double totalScoreWithWeight = 0;
        text = text.toLowerCase();
        input = input.toLowerCase();
        for (ScoreStrategy strategy : strategiesList) {
            currentWeight = strategy.getWeight();
            totalWeight += (long)currentWeight;
            totalScoreWithWeight += strategy.getScore(text, input) * currentWeight;
        }
        return totalScoreWithWeight / totalWeight;
    }

    /**
     * Compare strings by specific strategies
     * @param str1 First string
     * @param str2 Second string
     * @param input Search query string
     * @return Result of comparing two strings by specific strategies
     */
    private int fuzzyCompare(String str1, String str2, String input) {
        double strScore1 = getSimilarityScore(str1, input);
        double strScore2 = getSimilarityScore(str2, input);
        return Double.compare(strScore2, strScore1);
    }

}
