// https://leetcode.com/problems/valid-palindrome/

public class LC_125 {
    public static boolean isPalindrome(String s) {
        // Using 2 pointer approach to compare the characters from both sides
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Keeping the characters in variables for better readability
            char l = s.charAt(left);
            char r = s.charAt(right);

            if (!Character.isLetterOrDigit(l)) {
                // If the left character is not alphanumeric, we skip it
                left++;
            } else if (!Character.isLetterOrDigit(r)) {
                // If the right character is not alphanumeric, we skip it
                right--;
            } else if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                // If the characters are not equal, the string is not a palindrome
                return false;
            } else {
                // The characters are equal so we move the pointers inwards
                left++;
                right--;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("racecar"));
    }
}
