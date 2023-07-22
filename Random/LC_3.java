// https://leetcode.com/problems/longest-substring-without-repeating-characters/

import java.util.*;

public class LC_3 {
    public static int lengthOfLongestSubstring(String s) {
        // Taking a set because we want unique substring
        Set<Character> set = new HashSet<>();
        // Taking two pointers and setting them at 0
        int left = 0, right = 0, res = 0;

        // While our right pointer is less than the length
        while (right < s.length()) {
            // We take the character at the right pointer
            char ch = s.charAt(right);

            // If we have a duplicate in the set, we remove it and increase our
            // left pointer because it has to be at the first one
            if (set.contains(ch)) {
                set.remove(s.charAt(left));
                left++;
            } else {
                // If the character is not present, we add it in the set and increase our right pointer
                set.add(ch);
                right++;
            }

            // check for the max every time
            res = Math.max(res, set.size());
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
