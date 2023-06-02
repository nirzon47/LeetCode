import java.util.*;

public class IsSubsequence {

    public static boolean isSubsequence(String s, String t) {
        int sLen = s.length();
        if (sLen == 0)
            return true;

        // Converting the strings to char arrays because charAt is bad at runtime
        char[] sArray = s.toCharArray();
        char[] tArray = t.toCharArray();
        int j = 0;

        // Increments each character of sArray if there is a match with anywhere in tArray
        // If the length matches with j, it means all the characters in sArray have a match and returns true
        for (char c : tArray) {
            if (sArray[j] == c) {
                j++;
            }
            if (j == sLen) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(isSubsequence(s, t));
    }
}
