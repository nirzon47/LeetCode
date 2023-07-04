// https://leetcode.com/problems/prime-in-diagonal/

public class LC_2614 {
    public static boolean isPrime(int n) {
        // Checks if a number is prime or not
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }

    public static int diagonalPrime(int[][] nums) {
        int row = nums.length - 1;
        int max = 0;

        for (int i = 0; i <= row; i++) {
            // (i, i) is the left diagonal and (i, row - i) is the right diagonal
            // If the number is a diagonal, we check for max and update it accordingly
            if (isPrime(nums[i][i])) {
                max = Math.max(nums[i][i], max);
            }
            if (isPrime(nums[i][row - i])) {
                max = Math.max(nums[i][row - i], max);
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};

        System.out.println(diagonalPrime(nums));
    }
}
