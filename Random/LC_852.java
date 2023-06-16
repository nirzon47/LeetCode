// https://leetcode.com/problems/peak-index-in-a-mountain-array/

public class LC_852 {

    public static int peakIndexInMountainArray(int[] arr) {
        // Using binary search to find the largest element (peak) in the array
        int left = 0, right = arr.length - 1, mid;

        while (left < right) {
            mid = left + (right - left) / 2;
            // Checking arr[mid] with arr[mid+1] essentially
            int check = arr[mid + 1];

            // If arr[mid] is greater than arr[mid+1], we are descending, so we need to lower our upper bound
            if (arr[mid] > check) {
                right = mid;
            }
            // If arr[mid] is lesser than arr[mid+1], we are ascending still, so we up our lower bound
            else if (arr[mid] < check) {
                left = mid + 1;
            }
        }

        // We can return either left or right since they should be equal
        return left;

        /*
        Naive approach

        for (int i = 1; i < n - 1; i++) {
            if (arr[i] > arr[i - 1]) {
                res = i;
                break;
            }
        }

        return res;
         */
    }

    public static void main(String[] args) {
        int[] arr = {0, 10, 5, 2};
        System.out.println(peakIndexInMountainArray(arr));
    }
}
