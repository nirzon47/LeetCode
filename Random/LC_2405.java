// https://leetcode.com/problems/optimal-partition-of-string/

import java.util.*;

public class LC_2405 {
    public static int partitionString(String s) {
        // Initialising our count with 1 because the loop will not account for the last substring
        int count = 1;
        // Making a hashmap that makes our visited characters as seen
        boolean[] seen = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // If the character has already been visited, then
            // we need to take a new substring.
            // So we increase our count and reset our array.
            if (seen[c - 'a']) {
                count++;
                Arrays.fill(seen, false);
            }
            // If the character is not visited, we mark it as visited
            seen[c - 'a'] = true;
        }
        
        return count;
    }

    public static void main(String[] args) {
        System.out.println(partitionString("abacaba"));
    }
}
