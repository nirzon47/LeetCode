public class LC_628 {

    public static int maximumProduct(int[] nums) {
        // Taking the first three maximum numbers and the first two minimum numbers in one pass
        int max = Integer.MIN_VALUE, max2nd = Integer.MIN_VALUE, max3rd = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE, min2nd = Integer.MAX_VALUE;

        for (int num : nums) {
            // If a number greater than max is found, we swap the 3rd max with 2nd max,
            // 2nd max with the max and max with the number
            if (num > max) {
                max3rd = max2nd;
                max2nd = max;
                max = num;
            }
            // If a number greater than 2nd max is found, swap 3rd max with 2nd max and 2nd max with max
            else if (num > max2nd) {
                max3rd = max2nd;
                max2nd = num;
            } else if (num > max3rd) {
                max3rd = num;
            }

            // Same logic for minimums
            if (num < min) {
                min2nd = min;
                min = num;
            } else if (num < min2nd) {
                min2nd = num;
            }
        }

        // Our maximum number can be either the product of the first three maximum numbers
        // or the product of the first two minimum numbers (they will even out)
        // and the first maximum number, so we return the maximum between them
        return Math.max(max * max2nd * max3rd, max * min * min2nd);
    }

    public static void main(String[] args) {
        int[] nums = {-1, -2, -3};

        System.out.println(maximumProduct(nums));
    }
}
