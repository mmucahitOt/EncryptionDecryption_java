package encryptdecrypt.packages;

import java.util.Objects;

public class Helper {
    public static int findIndex(int[] arr, int t) {
        if (arr == null) {
            return -1;
        }
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (Objects.equals(arr[i], t)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static int findIndex(String[] arr, String t) {
        if (arr == null) {
            return -1;
        }
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (Objects.equals(arr[i], t)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static int findIndex(char[] arr, char t) {
        if (arr == null) {
            return -1;
        }
        int len = arr.length;
        int i = 0;
        while (i < len) {
            if (Objects.equals(arr[i], t)) {
                return i;
            }
            else {
                i = i + 1;
            }
        }
        return -1;
    }

    public static String mergeStrings(String[] strings) {
        StringBuilder builder = new StringBuilder();
        for (String string: strings) {
            builder.append(string);
        }

        return builder.toString();
    }
}
