package ru.shcoder.fuzzysearch;

/**
 * <h1>Class ScoreWeight</h1>
 * Specifying impact of strategy on result
 *
 * @author  Vasiliy Shilov (https://github.com/shcoder-ru)
 * @version 1.0
 * @since   2017-07-17
 */
public class ScoreWeight {

    /**
     * Score weight
     */
    private int weight;

    /**
     * Set score weight
     * @param value Score weight
     */
    public void setWeight(int value) {
        weight = value;
    }

    /**
     * Get score weight
     * @return Score weight
     */
    public int getWeight() {
        return weight;
    }

}
