package test.ftp;

import java.util.Iterator;
import java.util.StringJoiner;

public class StringUtils {

    private StringUtils() {
    }

    public static Integer tryParse(String str) {
        return tryParse(str, (Integer) null);
    }

    public static Integer tryParse(String str, Integer defaultValue) {
        Integer returnValue = defaultValue;

        try {
            if (isNotBlank(str)) {
                returnValue = Integer.parseInt(str);
            }
        } catch (Exception var4) {
        }

        return returnValue;
    }

    public static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !isEmpty(str);
    }

    public static boolean isBlank(String str) {
        int strLen;
        if (str != null && (strLen = str.length()) != 0) {
            for (int i = 0; i < strLen; ++i) {
                if (!Character.isWhitespace(str.charAt(i))) {
                    return false;
                }
            }

            return true;
        } else {
            return true;
        }
    }

    public static boolean isNotBlank(String str) {
        return !isBlank(str);
    }

    public static String toString(Object o) {
        return o != null ? o.toString() : null;
    }

    public static String join(String[] elements) {
        return join(elements, ",");
    }

    public static String join(Object[] elements) {
        return elements != null && elements.length != 0 ? join(convert(elements, true), ",") : null;
    }

    public static String join(Iterable<String> elements) {
        return join(elements, ",");
    }

    public static String join(String[] elements, String delimiter) {
        return elements != null && elements.length != 0 && delimiter != null ? join((CharSequence) delimiter, (CharSequence[]) ((CharSequence[]) elements)) : null;
    }

    public static String join(Iterable<String> elements, String delimiter) {
        return elements != null && delimiter != null ? join((CharSequence) delimiter, (Iterable) elements) : null;
    }

    private static String join(CharSequence delimiter, CharSequence... elements) {
        StringJoiner joiner = new StringJoiner(delimiter);
        CharSequence[] var3 = elements;
        int var4 = elements.length;

        for (int var5 = 0; var5 < var4; ++var5) {
            CharSequence cs = var3[var5];
            joiner.add(cs);
        }

        return joiner.toString();
    }

    private static String join(CharSequence delimiter, Iterable<? extends CharSequence> elements) {
        StringJoiner joiner = new StringJoiner(delimiter);
        Iterator var3 = elements.iterator();

        while (var3.hasNext()) {
            CharSequence cs = (CharSequence) var3.next();
            joiner.add(cs);
        }

        return joiner.toString();
    }

    public static String[] convert(Object[] input) {
        return convert(input, false);
    }

    public static String[] convert(Object[] input, boolean convertNullToBlank) {
        if (input == null) {
            return null;
        } else if (input.length == 0) {
            return new String[0];
        } else {
            String[] result = new String[input.length];
            String emptyFill = null;
            if (convertNullToBlank) {
                emptyFill = "";
            }

            for (int i = 0; i < input.length; ++i) {
                result[i] = input[i] != null ? input[i].toString() : emptyFill;
            }

            return result;
        }
    }

    public static String capitalize(String str) {
        return changeFirstCharacterCase(str, true);
    }

    private static String changeFirstCharacterCase(String str, boolean capitalize) {
        if (str != null && str.length() != 0) {
            StringBuilder sb = new StringBuilder(str.length());
            if (capitalize) {
                sb.append(Character.toUpperCase(str.charAt(0)));
            } else {
                sb.append(Character.toLowerCase(str.charAt(0)));
            }

            sb.append(str.substring(1));
            return sb.toString();
        } else {
            return str;
        }
    }

    public static String leftZeroPadding(int width, Integer value) {
        return value == null ? null : String.format("%0" + width + "d", value);
    }

    public static String leftZeroPadding(int width, Long value) {
        return value == null ? null : String.format("%0" + width + "d", value);
    }

    public static String toUnicode(char c) {
        return String.format("\\u%04x", Integer.valueOf(c));
    }

    public static String toUnicode(String input) {
        StringBuilder sb = new StringBuilder();
        char[] var2 = input.toCharArray();
        int var3 = var2.length;

        for (int var4 = 0; var4 < var3; ++var4) {
            char c = var2[var4];
            sb.append(toUnicode(c));
        }

        return sb.toString();
    }

}