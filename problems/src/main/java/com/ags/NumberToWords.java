package com.ags;

import java.util.HashMap;
import java.util.Map;

public class NumberToWords {
    String number;

    private Map<Integer, String> digitWord = new HashMap<>();
    private Map<Integer, String> tenDigitWord = new HashMap<>();
    private Map<Integer, String> teenDigitWord = new HashMap<>();
    private Map<Integer, String> weight = new HashMap<>();


    public NumberToWords(String number) {
        this.number = number;
        digitWord.put(1, "One");
        digitWord.put(2, "Two");
        digitWord.put(3, "Three");
        digitWord.put(4, "Four");
        digitWord.put(5, "Five");
        digitWord.put(6, "Six");
        digitWord.put(7, "Seven");
        digitWord.put(8, "Eight");
        digitWord.put(9, "Nine");

        tenDigitWord.put(1, "Ten");
        tenDigitWord.put(2, "Twenty");
        tenDigitWord.put(3, "Thirty");
        tenDigitWord.put(4, "Forty");
        tenDigitWord.put(5, "Fifty");
        tenDigitWord.put(6, "Sixty");
        tenDigitWord.put(7, "Seventy");
        tenDigitWord.put(8, "Eighty");
        tenDigitWord.put(9, "Ninety");

        teenDigitWord.put(1, "Eleven");
        teenDigitWord.put(2, "Twelve");
        teenDigitWord.put(3, "Thirteen");
        teenDigitWord.put(4, "Fourteen");
        teenDigitWord.put(5, "Fifteen");
        teenDigitWord.put(6, "Sixteen");
        teenDigitWord.put(7, "Seventeen");
        teenDigitWord.put(8, "Eighteen");
        teenDigitWord.put(9, "Nineteen");

        weight.put(3, "Hundred");
        weight.put(4, "Thousand");
        weight.put(6, "Hundred");
        weight.put(7, "Million");
        weight.put(9, "Hundred");
        weight.put(10, "Billion");
    }

    public String convertToWords() {
        StringBuilder words = new StringBuilder();
        Integer num = new Integer(number);
        boolean isTeen = false;

        for (int i = number.length(); i > 0; i--) {
            //System.out.println("num:"+num);
            double divisor = Math.pow(10, i - 1);
            int digit = (int) (num / divisor);
            if (digit == 0) continue;
            //System.out.println(i+":"+digit);

            if(isTeen) {
                words.append(teenDigitWord.get(digit));
                continue;
            }
            if (i == 2 || i == 5 || i == 8) {
                if(digit == 1) {
                    isTeen = true;
                } else {
                    words.append(tenDigitWord.get(digit));
                }
            } else {
                words.append(digitWord.get(digit));
                if (i != 1) words.append(weight.get(i));
            }

            num = num - (int)(digit * divisor);
            //System.out.println("num:"+num);
        }


        return words.toString();
    }
}
