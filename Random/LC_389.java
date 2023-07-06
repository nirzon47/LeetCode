// https://leetcode.com/problems/find-the-difference/

public class LC_389 {
    public static char findTheDifference(String s, String t) {
        // Adding up all the ASCII values of s and t strings
        // Return the difference between them, that is our extra character
        int sumS = 0, sumT = 0, len = t.length();

        for (int i = 0; i < len; i++) {
            if (i != len - 1) {
                sumS += s.charAt(i);
            }
            sumT += t.charAt(i);
        }

        return (char) (sumT - sumS);
    }

    public static void main(String[] args) {
        System.out.println(findTheDifference("abcd", "abcde"));
    }
}
