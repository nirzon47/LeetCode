// https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/

public class LC_1752 {
    public static boolean check(int[] nums) {
        int len = nums.length;

        // If the length of the array is 1, it has no sorting or rotation
        if (len == 1) {
            return true;
        }

        // Count to store the number of elements that are out of rotation or sorting
        int count = 0;

        for (int i = 0; i < len - 1; i++) {
            // If the current element is bigger than the next element, we increment count
            // which could mean that the element is the sorted index or the rotated index
            if (nums[i] > nums[i + 1]) {
                count++;
            }
        }

        if (nums[len - 1] > nums[0]) {
            // Since we are not checking for the last element with the first
            count++;
        }

        // If the count is smaller than or equal to 1, it means that our array is sorted and rotated only once which is valid
        // Anymore is a no no
        return count <= 1;
    }

    public static void main(String[] args) {
        System.out.println(check(new int[]{3, 4, 5, 1, 2}));
    }
}
