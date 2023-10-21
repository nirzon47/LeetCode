// https://leetcode.com/problems/truncate-sentence/

public class LC_1816 {
    public static String truncateSentence(String s, int k) {
        int pointer = 0;
        int word = 0;

        // Increasing pointer until our word count is less than k and pointer is smaller than s's length
        while (pointer < s.length() && word < k) {
            // If we find a space, we increase our word count
            if (s.charAt(pointer) == ' ') {
                word++;
            }

            pointer++;
        }

        // If the number of words is equal to k, that means we can form a truncated
        // string, so we return a substring from first until before the pointer ended
        // Otherwise, we return the original string
        return word == k ? s.substring(0, pointer - 1) : s;
    }

    public static void main(String[] args) {
        System.out.println(truncateSentence("Hello how are you Contestant", 4));
    }
}
