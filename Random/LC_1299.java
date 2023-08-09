// https://leetcode.com/problems/replace-elements-with-greatest-element-on-right-side/

import java.util.*;

public class LC_1299 {
    public static int[] replaceElements(int[] arr) {
        int len = arr.length;
        int[] res = new int[len];

        int max = -1;

        for (int i = len - 1; i >= 0; i--) {
            // If the current element is bigger than the max, we reserve the current max to put it in the result array
            // and make the current element as max
            if (arr[i] > max) {
                int temp = max;
                max = arr[i];
                res[i] = temp;
            } else {
                // Otherwise we just put the max element in the res array
                res[i] = max;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(replaceElements(new int[]{17, 18, 5, 4, 6, 1})));
    }
}
