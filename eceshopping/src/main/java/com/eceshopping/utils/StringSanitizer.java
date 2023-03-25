package com.eceshopping.utils;

import java.util.regex.Pattern;

public class StringSanitizer {
    private static final Pattern INVALID_CHARACTERS = Pattern.compile("[^\\p{L}\\p{N}\\s_.@-]");

    public static String sanitize(String input) {
        if (input == null) {
            return null;
        }

        String sanitized = input.trim();
        sanitized = removeInvalidCharacters(sanitized);
        sanitized = removeRedundantWhitespace(sanitized);
        return sanitized;
    }

    private static String removeInvalidCharacters(String input) {
        return INVALID_CHARACTERS.matcher(input).replaceAll("");
    }

    private static String removeRedundantWhitespace(String input) {
        return input.replaceAll("\\s+", " ");
    }
}