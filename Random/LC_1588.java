// https://leetcode.com/problems/sum-of-all-odd-length-subarrays/

public class LC_1588 {
    public static int sumOddLengthSubarrays(int[] arr) {
        int sum = 0, n = arr.length;

        // Counting every subarray and if its odd, we add it to the sum
        for (int i = 0; i < n; i++) {
            int count = 1, subArraySum = arr[i];
            sum += arr[i];
            for (int j = i + 1; j < n; j++) {
                count++;
                subArraySum += arr[j];
                if (count % 2 != 0) {
                    sum += subArraySum;
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 2, 5, 3};

        System.out.println(sumOddLengthSubarrays(arr));
    }
}
