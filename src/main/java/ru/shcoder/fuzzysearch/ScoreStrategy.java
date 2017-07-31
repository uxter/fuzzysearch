package ru.shcoder.fuzzysearch;

/**
 * <h1>Interface ScoreStrategy</h1>
 * Similarity calculation strategy for two strings.
 *
 * @author  Vasiliy Shilov (https://github.com/uxter)
 * @version 1.0
 * @since   2017-07-17
 */
public interface ScoreStrategy {

    /**
     * Set score weight
     * @param value Score weight
     */
    void setWeight(int value);

    /**
     * Get score weight
     * @return Score weight
     */
    int getWeight();

    /**
     * Get similarity score
     * @param str1 First string
     * @param str2 Second string
     * @return Similarity Score
     */
    double getScore(String str1, String str2);

}
