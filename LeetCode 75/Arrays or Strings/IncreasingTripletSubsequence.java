// https://leetcode.com/problems/increasing-triplet-subsequence/

import java.util.*;

public class IncreasingTripletSubsequence {

    public static boolean increasingTriplet(int[] nums) {
        int min = Integer.MAX_VALUE, secondMin = Integer.MAX_VALUE;

        // Finding the minimum and second minimum numbers till now and then if there exists a num that is bigger than min and secondMin,
        // we satisfy the condition needed
        for (int num : nums) {
            if (min >= num)
                min = num;
            else if (secondMin >= num)
                secondMin = num;
            else
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(increasingTriplet(nums));
    }
}
