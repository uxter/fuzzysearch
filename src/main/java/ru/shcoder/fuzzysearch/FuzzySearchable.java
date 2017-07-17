package ru.shcoder.fuzzysearch;

/**
 * <h1>Interface FuzzySearchable</h1>
 * Search strings by specific strategies.
 *
 * @author  Vasiliy Shilov (https://github.com/shcoder-ru)
 * @version 1.0
 * @since   2017-07-17
 */
public interface FuzzySearchable {

    /**
     * Add Similarity calculation strategy
     * @param strategy Similarity calculation strategy for two strings
     */
    public void addScoreStrategy(ScoreStrategy strategy);

    /**
     * Search for strings by specific strategies
     * @param list Source list of strings
     * @param input Search query string
     * @param limit Maximum number of results
     * @return Sorted list of strings
     */
    public String[] search(String[] list, String input, int limit);

}
