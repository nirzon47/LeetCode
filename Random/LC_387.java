// https://leetcode.com/problems/first-unique-character-in-a-string/

public class LC_387 {
    public static int firstUniqChar(String s) {
        int len = s.length();
        int res = Integer.MAX_VALUE;

        /* Intuition:
         * The way we check if a character is unique or not is by checking its
         * first and last indexes.
         * If they are the same, then that means that the character is unique
         * The minimum of the index we have and the index we already found is our result because
         * We need the first index of the unique character
         */

        // Iterating through a to z to make time complexity constant
        for (char i = 'a'; i <= 'z'; i++) {
            int index = s.indexOf(i);
            // Checking if index is negative just to make sure if that
            // character even exists in our given string
            if (index != -1 && s.lastIndexOf(i) == index) {
                res = Math.min(res, index);
            }
        }

        // If res is still the max value, we know that there are
        // no unique elements, so we return -1
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcode"));
    }
}
