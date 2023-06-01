// https://leetcode.com/problems/move-zeroes/

import java.util.*;

public class MoveZeroes {

    public static void moveZeroes(int[] nums) {
        int i = 0;

        // If the current element is not a 0, put it at the beginning
        for (int num : nums) {
            if (num != 0) {
                nums[i] = num;
                i++;
            }
        }

        // Replaces the items from the last updated value to the end of the array with 0
        // Arrays.fill is slightly worse at space management
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }

        // Garbage collection makes it extremely space efficient at the cost of 1ms speed
        System.gc();
        // Removing this print statement makes the solution run 12ms faster
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        moveZeroes(nums);
    }
}
