import java.util.*;

public class LC_14 {
    public static String longestCommonPrefix(String[] strs) {
        // Sorting the array, so we get the biggest difference in the characters
        Arrays.sort(strs);

        // Taking the first and the last string from the array
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int pointer = 0;

        // Until we have a different character for both the strings
        while (pointer < s1.length() && pointer < s2.length()) {
            if (s1.charAt(pointer) == s2.charAt(pointer)) {
                pointer++;
            } else {
                break;
            }
        }

        // If the pointer didn't move at all, we return an empty string,
        // otherwise we return the characters that are common
        return pointer == 0 ? "" : s1.substring(0, pointer);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
    }
}
