// https://leetcode.com/problems/remove-element/

public class LC_27 {
    public static int removeElement(int[] nums, int val) {
        // Taking 2 pointers, one that traverses through the array
        // another that looks for val
        int valPointer = 0, pointer = 0;
        int n = nums.length;

        while (pointer < n && valPointer < n) {
            // If our pointer does not point to val, we put the non-val pointer with the last seen val pointer
            if (nums[pointer] != val) {
                nums[valPointer] = nums[pointer];
                valPointer++;
            }

            pointer++;
        }

        // The length of our new array is the size of the array subtracted by the val(s)
        return valPointer;
    }

    public static void main(String[] args) {
        System.out.println(removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }
}
