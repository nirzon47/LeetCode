// https://leetcode.com/problems/strictly-palindromic-number/

public class LC_2396 {
    public static boolean isPalindrome(String n) {
        int left = 0, right = n.length() - 1;

        while (left < right) {
            if (n.charAt(left++) != n.charAt(right--)) {
                return false;
            }
        }

        return true;
    }

    public static boolean isStrictlyPalindromic(int n) {
        // Starting our iteration from 2 to n - 2 according to the question
        for (int i = 2; i < n - 1; i++) {
            // Using Integer.toString(number, base) to convert the number to the base we want
            // And the function above checks, if its palindrome or not
            // If it is not a palindrome, we return false
            if (!isPalindrome(Integer.toString(n, i))) {
                return false;
            }
        }

        // The answer is always false because the numbers for base (n - 2) are never palindromic for any number
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isStrictlyPalindromic(9));
    }
}
