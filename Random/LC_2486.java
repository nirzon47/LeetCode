// https://leetcode.com/problems/append-characters-to-string-to-make-subsequence/

public class LC_2486 {
    public static int appendCharacters(String s, String t) {
        // Taking two pointers
        int sLen = s.length(), tLen = t.length();
        int pS = 0, pT = 0;

        while (pS < sLen && pT < tLen) {
            // If the characters are same, we increase t's pointer because
            // we need to add t's substring to make t a subsequence of s
            if (s.charAt(pS) == t.charAt(pT)) {
                pT++;
            }

            pS++;
        }

        // If t's pointer reaches the end, we don't need to and anything else.
        // Otherwise, we return the characters left from the point we saw the common characters
        return pT == tLen ? 0 : tLen - pT;
    }

    public static void main(String[] args) {
        System.out.println(appendCharacters("coaching", "coding"));
    }
}
