// https://leetcode.com/problems/di-string-match/

import java.util.*;

public class LC_942 {
    public static int[] diStringMatch(String s) {
        int n = s.length();
        // Making an array to store the result, which is a size greater than the size of the string
        int[] res = new int[n + 1];
        // Assigning 2 pointers, D to right and I to left
        int left = 0, right = n;

        for (int i = 0; i < n; i++) {
            // If it's D, we put the index at right in the result array and for I, we put the index of left
            if (s.charAt(i) == 'D') {
                res[i] = right;
                right--;
            } else {
                res[i] = left;
                left++;
            }
        }

        // We still have one spot left and since left is smaller, it is bound to have the position for it
        res[n] = left;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(diStringMatch("IDID")));
    }
}
