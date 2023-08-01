// https://leetcode.com/problems/partition-labels/

import java.util.*;

public class LC_763 {
    public static List<Integer> partitionLabels(String s) {
        // Making an array that has the last index of each character in the string
        int[] lastIndex = new int[26];
        int n = s.length();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Max takes the largest index that has the other characters inside it
        // Start takes the index of the first index of the substrings
        int max = 0, start = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            // If another character exists inside the partition,
            // we take account of that, if it is bigger, it replaces the max
            max = Math.max(max, lastIndex[c - 'a']);

            // When we find the index which is equal to the max so far,
            // we know we have made a partition, so we add it to the list
            if (max == i) {
                res.add(max - start + 1);
                // Changing start to contain the index that is after the partition we just found
                start = max + 1;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(partitionLabels("ababcbacadefegdehijhklij"));
    }
}
