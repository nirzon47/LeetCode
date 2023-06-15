// https://leetcode.com/problems/merge-sorted-array/description 

public class LC_88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // Initialising pointers at the end of each array
        // Thinking nums1Pointer is the pointer that points at the end of nums1 with elements (not zeros)
        // nums2Pointer is the pointer that points at the end of nums2
        // resPointer points at the very end of nums1 where we have blank spaces
        int nums1Pointer = m - 1, nums2Pointer = n - 1, resPointer = m + n - 1;

        // Iterates until we run out of elements in nums2
        while (nums2Pointer >= 0) {
            // If the element at the end of nums1 is greater than the element at the end of nums2,
            // we replace the end of the resultant array with the greater number
            // same logic for else part but opposite

            // The extra condition of nums1Pointer being greater than equal to 0
            // is because if there are elements left in nums1 after incorporating
            // all the elements in nums2, we are already left with a sorted array
            if (nums1Pointer >= 0 && nums1[nums1Pointer] > nums2[nums2Pointer]) {
                nums1[resPointer--] = nums1[nums1Pointer--];
            } else {
                nums1[resPointer--] = nums2[nums2Pointer--];
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0}, nums2 = {2, 5, 6};
        int m = 3, n = 3;

        merge(nums1, m, nums2, n);
    }
}
