// https://leetcode.com/problems/sort-colors/

public class LC_75 {
    public static void sortColors(int[] nums) {
        // left manages 0s, mid manages 1s, right manages 2s
        int left = 0, mid = 0, right = nums.length - 1;
        // One pass solution

        // Checking if the last 1's position is less than or equal to the first 2's position
        while (mid <= right) {
            // If mid is 0, we swap it with 'left' (which has 0's pointer) and increase both 0's and 1's pointers
            if (nums[mid] == 0) {
                swap(nums, left, mid);
                left++;
                mid++;
            }
            // If mid is 1, it's in the right position, so we move on
            else if (nums[mid] == 1) {
                mid++;
            }
            // If mid is 2, we swap mid with 'right' (which has 2's pointer) and decrease 2's pointer
            else {
                swap(nums, mid, right);
                right--;
            }
        }


        /*
        2 pass solution, works well

        while (left < right) {
            if (nums[left] == 0) {
                left++;
            } else if (nums[right] > 0) {
                right--;
            } else {
                swap(nums, left, right);
            }
        }

        right = nums.length - 1;

        while (left < right) {
            if (nums[left] == 1) {
                left++;
            } else if (nums[right] == 2) {
                right--;
            } else {
                swap(nums, left, right);
            }
        }

         */

    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        sortColors(nums);

        for (int num : nums) System.out.print(num + " ");
    }
}


