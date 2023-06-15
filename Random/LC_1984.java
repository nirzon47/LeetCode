import java.util.*;

public class LC_1984 {

    public static int minimumDifference(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = k - 1;
        int diff, mindiff = Integer.MAX_VALUE;

        Arrays.sort(nums);

        while (right < n) {
            diff = nums[right] - nums[left];
            if (mindiff > diff)
                mindiff = diff;
            left++;
            right++;

        }
        return mindiff;

    }

    public static void main(String[] args) {
        int[] nums = {9, 4, 1, 7};
        int k = 2;

        System.out.println(minimumDifference(nums, k));

    }
}
