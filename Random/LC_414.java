public class LC_414 {

    public static int thirdMax(int[] nums) {
        int max = Integer.MIN_VALUE, max2nd = Integer.MIN_VALUE, max3rd = Integer.MIN_VALUE;

        for (int num : nums) {
            if (max == num || max2nd == num || max3rd == num) continue;
            if (num > max) {
                max3rd = max2nd;
                max2nd = max;
                max = num;
            } else if (num > max2nd) {
                max3rd = max2nd;
                max2nd = num;
            } else if (num > max3rd) {
                max3rd = num;
            }
        }

        return max3rd == Integer.MIN_VALUE ? max : max3rd;
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 1};

        System.out.println(thirdMax(nums));
    }
}
