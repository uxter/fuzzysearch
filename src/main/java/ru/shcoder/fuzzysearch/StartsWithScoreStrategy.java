package ru.shcoder.fuzzysearch;

/**
 * <h1>Class StartsWithScoreStrategy</h1>
 * Similarity calculation strategy for two strings by number of matches at beginning of word
 *
 * @author  Vasiliy Shilov (https://github.com/uxter)
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
        int sharedWordsStartCount = 0;
        String regSpaces = "\\s+";
        String[] strWords1 = str1.split(regSpaces);
        String[] strWords2 = str2.split(regSpaces);
        for (int i = 0; i < strWords2.length; i++) {
            for (int j = 0; j < strWords1.length; j++) {
                if (strWords1[j] != null && strWords2[i] != null && strWords1[j].contains(strWords2[i])) {
                    strWords1[j] = null;
                    strWords2[i] = null;
                    sharedWordsStartCount++;
                }
            }
        }
        return (double)sharedWordsStartCount / (strWords2.length + strWords1.length - sharedWordsStartCount);
    }

}
