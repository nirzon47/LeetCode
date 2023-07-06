// https://leetcode.com/problems/minimum-number-of-operations-to-move-all-balls-to-each-box/

import java.util.*;

public class LC_1769 {
    public static int[] minOperations(String boxes) {
        int len = boxes.length();
        int[] res = new int[len];

        int count = 0, ops = 0;

        // Using prefix sums from both sides
        // count holds the sum of the number of balls we have encountered so far
        // ops holds the number of operations
        for (int i = 0; i < len; i++) {
            res[i] += ops;
            count += boxes.charAt(i) - '0';
            ops += count;
        }

        count = 0;
        ops = 0;
        for (int i = len - 1; i >= 0; i--) {
            res[i] += ops;
            count += boxes.charAt(i) - '0';
            ops += count;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(minOperations("001011")));
    }
}
