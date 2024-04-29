package com.stefaninitest;

import org.junit.Before;
import org.junit.Test;

import static com.stefaninitest.utils.TestUtils.OUTPUT;
import static com.stefaninitest.utils.TestUtils.TEXT;
import static org.junit.Assert.assertEquals;

public class TextHandlerTest {

    private TextHandler textHandler;

    @Before
    public void initializeTextHandler() {
        textHandler = new TextHandler(TEXT);
    }

    @Test
    public void textHandlerShouldCountTotalNumberOfWordsCorrectlyTest() {
        final int expectedNumberOfWords = 43;

        final int actualNumberOfWords = textHandler.getNumberOfWords();

        assertEquals(expectedNumberOfWords, actualNumberOfWords);
    }

    @Test
    public void textHandlerShouldCountTotalNumberOfSentencesCorrectlyTest() {
        final int expectedNumberOfSentences = 2;

        final int actualNumberOfSentences = textHandler.getNumberOfSentences();

        assertEquals(expectedNumberOfSentences, actualNumberOfSentences);
    }

    @Test
    public void textHandlerShouldCountCorrectlyTest() {
        final int expectedCountOfWord = 2;
        final String word = "lorem ipsum";

        final int actualCountOfWord = textHandler.countPhrases(2).getOrDefault(word, -1);

        assertEquals(expectedCountOfWord, actualCountOfWord);
    }

    @Test
    public void textHandlerShouldGetCorrectOutputTest(){
        final String actualOutput = textHandler.showInfo(5, 2);

        assertEquals(OUTPUT, actualOutput);
    }
}
