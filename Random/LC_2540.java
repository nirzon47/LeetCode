// https://leetcode.com/problems/minimum-common-value/

public class LC_2540 {
    public static int getCommon(int[] nums1, int[] nums2) {
        // Using 2 pointers
        int ptr1 = 0, ptr2 = 0;

        // Loop goes until one of the pointers exceed the limit of their arrays
        while (ptr1 < nums1.length && ptr2 < nums2.length) {
            // If the nums1 element is bigger than the nums2 element,
            // we increase our nums2 pointer because an intersection is not possible.
            // Same case where the nums2 element is bigger than the nums1 element
            // If both are equal, it intersected
            if (nums1[ptr1] > nums2[ptr2]) {
                ptr2++;
            } else if (nums1[ptr1] < nums2[ptr2]) {
                ptr1++;
            } else {
                return nums1[ptr1];
            }
        }

        // Throwaway return function to make the code works
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3}, nums2 = {2, 4};
        System.out.println(getCommon(nums1, nums2));
    }
}
