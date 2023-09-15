// https://leetcode.com/problems/relative-sort-array/

import java.util.*;

public class LC_1122 {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        // We make a hashmap of the max number of elements we can hold
        int[] map = new int[1001];

        // In the map, we store the frequency of each element
        for (int a : arr1) {
            map[a]++;
        }

        // We make a new array of the same size as the first array
        int[] res = new int[arr1.length];
        int ptr = 0;

        // When we iterate through the second array,
        // we also populate it according the frequency we
        // found in the map, we also decrease it each step to make it 0
        for (int a : arr2) {
            while (map[a]-- > 0) {
                res[ptr++] = a;
            }
        }

        // We go through the array once again to add the strays in ascending order
        for (int i = 0; i < 1001; i++) {
            while (map[i]-- > 0) {
                res[ptr++] = i;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(relativeSortArray(new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19}, new int[]{2, 1, 4, 3, 9, 6})));
    }
}
