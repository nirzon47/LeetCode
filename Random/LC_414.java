// https://leetcode.com/problems/third-maximum-number/

public class LC_414 {

    public static int thirdMax(int[] nums) {
        // Initializing with long because Integer.MIN may be one of the test cases
        long max = Long.MIN_VALUE, max2nd = Long.MIN_VALUE, max3rd = Long.MIN_VALUE;

        for (Integer num : nums) {
            // Checking for duplicates, if found, we skip this iteration
            if (num == max || num == max2nd || num == max3rd) continue;

            // If num is greater than max, we swap 3rd max with 2nd max,
            // 2nd max with max and max with num
            if (num > max) {
                max3rd = max2nd;
                max2nd = max;
                max = num;
            }
            // If num is greater than 2nd max, we swap 3rd max with 2nd max
            // and 2nd max with num
            else if (num > max2nd) {
                max3rd = max2nd;
                max2nd = num;
            }
            // If num is greater than max, we swap 3rd max with the number
            else if (num > max3rd) {
                max3rd = num;
            }
        }

        // If the 3rd max is still the minimum value, that means we don't have 3 distinct numbers to work with, so
        // we return the maximum number.
        // If there is a 3rd max, we simply return that.
        return (int) (max3rd == Long.MIN_VALUE ? max : max3rd);
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};

        System.out.println(thirdMax(nums));
    }
}
