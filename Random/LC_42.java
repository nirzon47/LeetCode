// https://leetcode.com/problems/trapping-rain-water/

public class LC_42 {
    public static int trap(int[] height) {
        // Using two pointers to find the maxLeft and maxRight in each case
        int left = 0, right = height.length - 1;
        int maxL = height[left], maxR = height[right];
        int res = 0;

        while (left < right) {
            // Finding the max pointers
            maxL = Math.max(height[left], maxL);
            maxR = Math.max(height[right], maxR);

            // If right max is greater than left max, we find the water trapped on the left side
            // the max element on the left - the current building is the water that can be trapped
            // We are sure that the right side can hold as much water as the left side's because we check for it
            // We add the trapped water and shift our pointer
            if (maxL < maxR) {
                res += maxL - height[left];
                left++;
            } else {
                // Same logic here, but we also do the same for when both the max are equal because it doesn't matter
                res += maxR - height[right];
                right--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
