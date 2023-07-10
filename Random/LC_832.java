// https://leetcode.com/problems/flipping-an-image/

import java.util.*;

public class LC_832 {
    public static void flip(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;

            left++;
            right--;
        }
    }

    public static void invert(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else {
                nums[i] = 0;
            }
        }
    }

    public static int[][] flipAndInvertImage(int[][] image) {
        for (int[] r : image) {
            // We pass the row to a function that first reverses the array
            flip(r);
            // Then we swap the 1s to 0s and 0s to 1s
            invert(r);
        }

        return image;
    }

    public static void main(String[] args) {
        int[][] image = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        System.out.println(Arrays.deepToString(flipAndInvertImage(image)));
    }
}
