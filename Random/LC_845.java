// https://leetcode.com/problems/longest-mountain-in-array/

public class LC_845 {
    public static int longestMountain(int[] arr) {
        int max = 0;

        for (int i = 1; i < arr.length - 1; i++) {
            // If this condition passes, arr[i] is a peak surrounded by smaller elements
            if (arr[i - 1] < arr[i] && arr[i] > arr[i + 1]) {
                // We make two pointers and expand them until the left is bigger than left - 1,
                //  and the right is bigger than right - 1
                int left = i - 1;
                int right = i + 1;

                while (left > 0 && arr[left - 1] < arr[left]) {
                    left--;
                }
                while (right < arr.length - 1 && arr[right] > arr[right + 1]) {
                    right++;
                }

                // We check the max and the current peak we found
                max = Math.max(max, right - left + 1);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(longestMountain(new int[]{2, 1, 4, 7, 3, 2, 5}));
    }
}
