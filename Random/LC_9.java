// https://leetcode.com/problems/palindrome-number/

public class LC_9 {
    public static boolean isPalindrome(int x) {
        // If x is negative, the number is not a palindrome because of the negative sign
        if (x < 0) {
            return false;
        }

        // Storing x and making a new X
        int temp = x, newX = 0;

        while (x > 0) {
            int digit = x % 10;
            newX = newX * 10 + digit;
            x /= 10;
        }

        // If the original x is equal to our new x, we return true
        return temp == newX;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(-121));
    }
}
