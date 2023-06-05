// https://leetcode.com/problems/determine-if-two-strings-are-close/

import java.util.*;

public class DetermineIfTwoStringsAreClose {
    public static boolean closeStrings(String word1, String word2) {
        // Making two arrays that contain the frequencies of each alphabet
        int[] freq1 = new int[26], freq2 = new int[26];
        for (char ch : word1.toCharArray()) {
            freq1[ch - 'a']++;
        }
        for (char ch : word2.toCharArray()) {
            freq2[ch - 'a']++;
        }

        // If the frequency of word1[i] is 0 and the frequency of word2[i] is not 0 or
        // the frequency of word1[i] is not 0 and the frequency of word2[i] is 0
        // means that both the words do not contain the current alphabet
        for (int i = 0; i < 26; i++) {
            // XOR (^) implies (freq1[i] == 0 && freq2[i] != 0) || (freq1[i] != 0 && freq2[i] == 0)
            if (freq1[i] == 0 ^ freq2[i] == 0) return false;
        }

        // If the strings are close, the sorted arrays of their frequencies should be the same
        Arrays.sort(freq1);
        Arrays.sort(freq2);

        return Arrays.equals(freq1, freq2);

    }

    public static void main(String[] args) {
        String word1 = "abc", word2 = "bca";

        System.out.println(closeStrings(word1, word2));
    }
}
