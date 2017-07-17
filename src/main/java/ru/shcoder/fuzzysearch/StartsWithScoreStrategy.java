package ru.shcoder.fuzzysearch;

import java.util.Arrays;

/**
 * <h1>Class StartsWithScoreStrategy</h1>
 * Similarity calculation strategy for two strings by number of matches at beginning of word
 *
 * @author  Vasiliy Shilov (https://github.com/shcoder-ru)
 * @version 1.0
 * @since   2017-07-17
 */
public class StartsWithScoreStrategy extends ScoreWeight implements ScoreStrategy {

    /**
     * Get similarity score by number of matches at beginning of word
     * @param str1 First string
     * @param str2 Second string
     * @return Similarity Score
     */
    public double getScore(String str1, String str2) {
        int sharedWordsCount = 0;
        String regSpaces = "\\s+";
        String[] strWords1 = str1.split(regSpaces);
        String[] strWords2 = str2.split(regSpaces);
        for (String word : strWords2) {
            /**
             * @TODO implement
             */
        }
        return (double)sharedWordsCount / (strWords2.length + strWords1.length - sharedWordsCount);
    }

}