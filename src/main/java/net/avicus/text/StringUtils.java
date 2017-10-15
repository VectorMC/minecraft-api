package net.avicus.text;

public interface StringUtils {

    static String truncate(String text, int length) {
        return text.substring(0, Math.min(text.length(), length));
    }
}
