// https://leetcode.com/problems/largest-number/

import java.util.*;

public class LC_179 {

    public static String largestNumber(int[] nums) {
        int len = nums.length;
        // The length of the array is 0, there is no largest
        if (nums.length == 0) return "";

        // Putting all the numbers in a string array
        String[] sArray = new String[len];

        for (int i = 0; i < len; i++) {
            sArray[i] = String.valueOf(nums[i]);
        }
        // Sorting the string array with a comparator
        Arrays.sort(sArray, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Concatenating the comparing strings from both sides for
                // cases like 364 and 36, we want 364 to go first
                String temp1 = o1.concat(o2);
                String temp2 = o2.concat(o1);

                // Returns which are lexicographically higher
                return temp2.compareTo(temp1);
            }
        });

        // If the first character is 0 after all that sorting, the result has to be just zero
        if (sArray[0].charAt(0) == '0') return "0";

        // Puts the string array in a StringBuilder for output
        StringBuilder res = new StringBuilder();
        for (String s : sArray) res.append(s);

        return res.toString();
    }

    public static void main(String[] args) {
        int[] nums = {3, 30, 34, 5, 9};

        System.out.println(largestNumber(nums));
    }
}
