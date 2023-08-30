// https://leetcode.com/problems/ways-to-make-a-fair-array/

public class LC_1664 {
    public static int waysToMakeFair(int[] nums) {
        int rightEvenSum = 0, rightOddSum = 0;
        int leftEvenSum = 0, leftOddSum = 0;
        int len = nums.length;
        int count = 0;

        // Finding the sum of the even and odd indices
        for (int i = 0; i < len; i++) {
            if (i % 2 == 0) {
                rightEvenSum += nums[i];
            } else {
                rightOddSum += nums[i];
            }
        }

        for (int i = 0; i < len; i++) {
            // We remove the current element from the even or odd sum depending on the index
            if (i % 2 == 0) {
                rightEvenSum -= nums[i];
            } else {
                rightOddSum -= nums[i];
            }

            // Since removing an element makes the even odd opposite, we add the
            // even sum with the odd sum and then check if they are equal
            // If they are equal, we have a fair array
            if (rightEvenSum + leftOddSum == rightOddSum + leftEvenSum) {
                count++;
            }

            // We later add the removed element back in a different sum
            if (i % 2 == 0) {
                leftEvenSum += nums[i];
            } else {
                leftOddSum += nums[i];
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(waysToMakeFair(new int[]{2, 1, 6, 4}));
    }
}
