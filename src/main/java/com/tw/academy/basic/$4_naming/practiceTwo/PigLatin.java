package com.tw.academy.basic.$4_naming.practiceTwo;

import java.util.Arrays;
import java.util.List;

public class PigLatin {
    public static final String BLANK_STRING = " ";
    public static final String SUFFIX = "ay";
    static List<String> specialSymbols= Arrays.asList(".",",","-",":",";","!","?");

    //Move the first letter of each word to the end of it, then add "ay" to the end of the word. Leave punctuation marks untouched.
    public static String pigIt(String sentence) {
        String[] words = sentence.split(BLANK_STRING);
        char firstLetter;

        for (int i = 0; i < words.length; i++){
            if (isSpecialSymbols(specialSymbols, words[i])) {
                break;
            }
            firstLetter = words[i].charAt(0);
            words[i] = words[i].substring(1);
            words[i] = words[i].replace(words[i], words[i] + firstLetter + SUFFIX);
        }

        return String.join(" ", words);
    }

    private static boolean isSpecialSymbols(List<String> specialSymbols, String pigLatinWord) {
        return specialSymbols.contains(pigLatinWord);
    }
}
