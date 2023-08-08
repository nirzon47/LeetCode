// https://leetcode.com/problems/valid-palindrome-ii/

public class LC_680 {
    public static boolean isPalindrome(char[] chars, int left, int right) {
        boolean flag = true;
        while (left < right) {
            if (chars[left] != chars[right]) {
                flag = false;
                break;
            }

            left++;
            right--;
        }

        return flag;
    }

    public static boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();

        int left = 0, right = chars.length - 1;

        while (left < right) {
            if (chars[left] != chars[right]) {
                // We check if the rest part of the string is a palindrome or not if
                // we found a case where the palindrome is not matching
                return isPalindrome(chars, left + 1, right) || isPalindrome(chars, left, right - 1);
            } else {
                right--;
                left++;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(validPalindrome("abca"));
    }
}
