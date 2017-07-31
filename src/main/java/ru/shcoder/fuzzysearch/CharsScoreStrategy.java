package ru.shcoder.fuzzysearch;

/**
 * <h1>Class CharsScoreStrategy</h1>
 * Similarity calculation strategy for two strings by number of matching chars
 *
 * @author  Vasiliy Shilov (https://github.com/uxter)
 * @version 1.0
 * @since   2017-07-17
 */
public class CharsScoreStrategy extends ScoreWeight implements ScoreStrategy {

    /**
     * Get similarity score by number of matching chars
     * @param str1 First string
     * @param str2 Second string
     * @return Similarity Score
     */
    public double getScore(String str1, String str2) {
        int sharedCharsCount = 0;
        for(int i = 0; i < str1.length(); i++) {
            String subStr2 = str2.substring(sharedCharsCount);
            int matchedCharIndex = subStr2.indexOf(str1.charAt(i));
            if (matchedCharIndex > -1) {
                sharedCharsCount++;
            }
        }
        return (double)sharedCharsCount / (str2.length() + str1.length() - sharedCharsCount);
    }

}
