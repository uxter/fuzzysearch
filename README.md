[![Build Status](https://travis-ci.org/uxter/fuzzysearch.svg?branch=master)](https://travis-ci.org/uxter/fuzzysearch)
[![Coverage Status](https://codecov.io/gh/uxter/fuzzysearch/branch/master/graph/badge.svg)](https://codecov.io/gh/uxter/fuzzysearch)
[![Join the chat at https://gitter.im/fuzzysearch](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/fuzzysearch?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

# FuzzySearch
Implementing a Fuzzy Search Algorithm in Java with possible to extend by adding similarity calculation strategy.

## Classes [WordsScoreStrategy](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/WordsScoreStrategy.java), [StartsWithScoreStrategy](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/StartsWithScoreStrategy.java), [CharsScoreStrategy](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/CharsScoreStrategy.java)
*implements [ScoreStrategy](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/ScoreStrategy.java)*

Create similarity calculation strategy.
``` java
WordsScoreStrategy wordsScoreStrategyInstance = new WordsScoreStrategy();
StartsWithScoreStrategy startsWithScoreStrategyInstance = new StartsWithScoreStrategy();
CharsScoreStrategy charsScoreStrategyInstance = new CharsScoreStrategy();
```

### Method [setWeight(int value)](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/ScoreWeight.java#L22)
Set score weight.

###### Parameters

| Param | Type | Description |
| --- | --- | --- |
| value | <code>int</code> | Score weight |

``` java
wordsScoreStrategyInstance.setWeight(2);
startsWithScoreStrategyInstance.setWeight(5);
charsScoreStrategyInstance.setWeight(3);
```

## Class [FuzzySearch](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/FuzzySearch.java)
*implements [FuzzySearchable](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/FuzzySearchable.java)*

Create searcher.
``` java
FuzzySearch Searcher = new FuzzySearch();
```

### Method [addScoreStrategy(ScoreStrategy strategy)](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/FuzzySearch.java#L23)
Add Similarity calculation strategy.

###### Parameters

| Param | Type | Description |
| --- | --- | --- |
| strategy | <code>ScoreStrategy</code> | Similarity calculation strategy |

``` java
Searcher.addScoreStrategy(wordsScoreStrategyInstance);
Searcher.addScoreStrategy(startsWithScoreStrategyInstance);
Searcher.addScoreStrategy(charsScoreStrategyInstance);
```

### Method [search(String[] list, String input, int limit)](https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/FuzzySearch.java#L23)
Search.

###### Parameters

| Param | Type | Description |
| --- | --- | --- |
| list | <code>String[]</code> | Source list of strings |
| input | <code>String</code> | Search query string |
| limit | <code>int</code> | Maximum number of results |

###### Return

| Param | Type |
| --- | --- |
| <code>String[]</code> | Sorted list of strings |

``` java
String[] sourceList = new String[]{
    "Java",
    "JavaScript",
    "C++"
};
String[] resultList = Searcher.search(sourceList, "Java", 10));
```

## Interfaces

<dl>
<dt><a href="https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/FuzzySearchable.java">FuzzySearchable</a></dt>
<dd></dd>
<dt><a href="https://github.com/uxter/fuzzysearch/blob/master/src/main/java/ru/shcoder/fuzzysearch/ScoreStrategy.java">ScoreStrategy</a></dt>
<dd></dd>
</dl>


## Note on Patches/Pull Requests

1. Fork the project.
2. Make your feature addition or bug fix.
3. Send me a pull request.

* * *

&copy; 2017 Vasily Shilov
