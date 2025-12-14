package org.patrick;

public class Util {

    /**
     * Converts a string to title case
     * @param str the input string
     * @return The string converted to title case
     */
    public static String toTitleCase(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }

        String[] words  = str.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            String word = words[i];

            if (!word.isEmpty()) {
                String firstChar = word.substring(0, 1).toUpperCase();
                String rest = word.substring(1).toLowerCase();
                result += firstChar + rest;
            }

            if (i < words.length - 1) {
                result += " ";
            }
        }
        return result;
    }
}
