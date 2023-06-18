// https://leetcode.com/problems/number-of-arithmetic-triplets/

import java.util.*;

public class LC_2367 {

    public static int arithmeticTriplets(int[] nums, int diff) {
        // Taking a hashset and putting all the elements we have encountered so far
        HashSet<Integer> checked = new HashSet<>();
        int count = 0;

        // If there exists an element which is the difference between num and diff and num and diff*2 in the hash set
        // We increase our count since we found a triplet,
        // This only works because the inputs are strictly increasing according to the question
        for (int num : nums) {
            if (checked.contains(num - diff) && checked.contains(num - 2 * diff)) count++;
            checked.add(num);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 8, 9};
        int diff = 3;

        System.out.println(arithmeticTriplets(nums, diff));
    }
}
