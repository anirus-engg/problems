package com.ags;

import com.ags.numberWords.NumberToWords;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NumberWordsTest {

    @Test
    public void numberTestOne() {
        NumberToWords numberToWords = new NumberToWords("5");
        assertEquals("Five", numberToWords.convertToWords());
    }

    @Test
    public void numberTestTwo() {
        NumberToWords numberToWords = new NumberToWords("20");
        assertEquals("Twenty", numberToWords.convertToWords());
    }

    @Test
    public void numberTestTwoTeen() {
        NumberToWords numberToWords = new NumberToWords("19");
        assertEquals("Nineteen", numberToWords.convertToWords());
    }

    @Test
    public void numberTestThree() {
        NumberToWords numberToWords = new NumberToWords("109");
        assertEquals("OneHundredNine", numberToWords.convertToWords());
    }

    @Test
    public void numberTestFour() {
        NumberToWords numberToWords = new NumberToWords("7591");
        assertEquals("SevenThousandFiveHundredNinetyOne", numberToWords.convertToWords());
    }

    @Test
    public void numberTestFourTeen() {
        NumberToWords numberToWords = new NumberToWords("7514");
        assertEquals("SevenThousandFiveHundredFourteen", numberToWords.convertToWords());
    }

    @Test
    public void numberTestFive() {
        NumberToWords numberToWords = new NumberToWords("71525");
        assertEquals("SeventyOneThousandFiveHundredTwentyFive", numberToWords.convertToWords());
    }

    @Test
    public void numberTestTen() {
        NumberToWords numberToWords = new NumberToWords("1000071525");
        assertEquals("OneBillionSeventyOneThousandFiveHundredTwentyFive", numberToWords.convertToWords());
    }
}
