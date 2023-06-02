// https://leetcode.com/problems/container-with-most-water/

import java.util.*;

public class ContainerWithMostWater {

    public static int maxArea(int[] height) {
        // Using two pointer technique. Default area is 0.
        int left = 0, right = height.length - 1, res = 0;

        // Taking breadth as the difference between the pointers and length as the minimum between the two values
        // since if we take the max value, it will overflow from a side
        while (left < right) {
            int breadth = right - left;
            int area;

            // the smaller pointer value is checked and then the area is calculated and the pointer is accordingly shifted
            if (height[left] > height[right]) {
                area = breadth * height[right];
                right--;
            } else {
                area = breadth * height[left];
                left++;
            }
            // if the current area is more than the maximum area so far, we switch them
            if (area > res)
                res = area;
        }

        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        System.out.println(maxArea(height));
    }
}
