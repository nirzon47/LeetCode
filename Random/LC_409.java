// https://leetcode.com/problems/longest-palindrome/

public class LC_409 {
    public static int longestPalindrome(String s) {
        int[] freq = new int[128];
        int oddCount = 0;
        int len = s.length();

        /* Intuition:
         * We check if all our characters are in even or odd frequencies
         * If it is even, then they can be added to our palindrome no issues,
         * But if it is odd, we need to remove one element (in case it's more than 1)
         * So in case of 7, we take the first 6 occurrences but remove the last occurrence
         * Our result is the length of the string without the odd count characters
         */

        for (int i = 0; i < len; i++) {
            // Unconditionally updating frequency array
            char ch = s.charAt(i);
            freq[ch]++;

            // If our current character has an odd frequency, we increase the oddCount
            if (freq[ch] % 2 == 1) {
                oddCount++;
            }
            // If it is even, we decrease it
            else {
                oddCount--;
            }
        }

        return oddCount > 1 ? len - oddCount + 1 : len;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("abccccdd"));
    }
}
