// https://leetcode.com/problems/permutation-in-string/

import java.util.*;

public class LC_567 {
    public static boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();

        // If the length of the 2nd string is smaller than the 1st string,
        // it's not possible for there to exist a solution
        if (len1 > len2) {
            return false;
        }

        // Making frequency arrays for both the strings
        int[] freq1 = new int[26];
        int[] freq2 = new int[26];

        for (int i = 0; i < len1; i++) {
            // Making a window of frequency arrays
            freq1[s1.charAt(i) - 'a']++;
            freq2[s2.charAt(i) - 'a']++;
        }

        // If the window matches in the first go, we return true
        if (Arrays.equals(freq1, freq2)) {
            return true;
        }

        int left = 0;
        int right = len1;
        // Sliding a window and checking their frequencies along the way, if there is a match, we return true
        while (right < len2) {
            freq2[s2.charAt(left) - 'a']--;
            freq2[s2.charAt(right) - 'a']++;

            if (Arrays.equals(freq1, freq2)) {
                return true;
            }
            left++;
            right++;
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }
}
