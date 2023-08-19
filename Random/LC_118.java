// https://leetcode.com/problems/pascals-triangle/description/

import java.util.*;

public class LC_118 {
    public static List<List<Integer>> generate(int numRows) {
        // Initialising our list with at least one part of the pascal's triangle and adding it to the result
        Integer[] prev = {1};
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(prev));

        // Starting from 2 every time and going till its equal to numRows
        for (int i = 2; i <= numRows; i++) {
            // Making a new integer array (wrapper class to avoid errors while adding it as a list)
            // with the size i which increases every iteration
            Integer[] next = new Integer[i];

            // Populating the array
            for (int j = 0; j < i; j++) {
                // If it is either the first or the last element, we keep it at 1
                if (j == 0 || j == i - 1) {
                    next[j] = 1;
                } else {
                    // Otherwise, we do this to get the sum of the above pascal's triangle's sums
                    next[j] = prev[j - 1] + prev[j];
                }
            }

            // Adding our new array to the result
            // And setting our new array as the previous one
            res.add(Arrays.asList(next));
            prev = next;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(generate(5));
    }
}