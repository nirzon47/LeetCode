// https://leetcode.com/problems/reverse-only-letters/description/

public class LC_917 {
    public static void swap(char[] chars, int left, int right) {
        char temp = chars[left];
        chars[left] = chars[right];
        chars[right] = temp;
    }

    public static String reverseOnlyLetters(String s) {
        // Converting the string to a char array
        char[] chars = s.toCharArray();
        // Using two pointers
        int left = 0, right = chars.length - 1;

        while (left < right) {
            // If both the characters are letters, we swap them and change both the pointers
            if (Character.isLetter(chars[left]) && Character.isLetter(chars[right])) {
                swap(chars, left, right);
                left++;
                right--;
            } else if (!Character.isLetter(chars[left])) {
                // If the left pointer does not have a letter, we increase it
                left++;
            } else if (!Character.isLetter(chars[right])) {
                // If the right pointer does not have a letter, we decreas it
                right--;
            }
        }

        // Return the char array
        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
    }
}
