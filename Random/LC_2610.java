// https://leetcode.com/problems/convert-an-array-into-a-2d-array-with-conditions/

import java.util.*;

public class LC_2610 {
    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        // Making a frequency array that stores the frequency of all the inputs
        int[] map = new int[201];
        int rMax = Integer.MIN_VALUE;

        for (int num : nums) {
            // Populating the frequency array and finding the maximum frequency
            map[num]++;
            rMax = Math.max(map[num], rMax);
        }

        // The number of lists we will have is equal to the maximum frequency in the array
        // We iterate rMax number of times
        for (int i = 0; i < rMax; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 1; j < 201; j++) {
                int currentFreq = map[j];

                // If the frequency of the element is more than 0, we add it in our list
                if (currentFreq <= 0) {
                    continue;
                } else {
                    row.add(j);
                }
                // Decreasing the frequency to avoid duplicates
                map[j]--;
            }
            res.add(row);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 1, 2, 3, 1};
        System.out.println(findMatrix(nums));
    }
}
