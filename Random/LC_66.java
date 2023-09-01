// https://leetcode.com/problems/plus-one/

import java.util.*;

public class LC_66 {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;

        // Traversing from the back if we find a value smaller than 9,
        // meaning 0 to 8, we just add one to the number and return the array
        for (int i = len - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;

                return digits;
            }

            // If it is 9, we make it 0
            digits[i] = 0;
        }

        // If we are here, it means the first number of the array was also 9,
        // so we need to increase the array's length
        // To do that, we make a new array with increased length and for the first index we make it 1
        int[] res = new int[len + 1];
        res[0] = 1;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(plusOne(new int[]{9})));
    }
}
