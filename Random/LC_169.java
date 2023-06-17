// https://leetcode.com/problems/majority-element/

public class LC_169 {

    public static int majorityElement(int[] nums) {
        // Using moore's algorithm since question assumes that a majority exists
        int res = nums[0], count = 0;
        
        for (int num : nums) {
            if (count == 0) {
                res = num;
                count++;
            } else {
                if (num != res)
                    count--;
                else
                    count++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2};

        System.out.println(majorityElement(nums));
    }
}
