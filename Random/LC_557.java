// https://leetcode.com/problems/reverse-words-in-a-string-iii/

public class LC_557 {
    public static void reverse(char[] chars, int left, int right) {
        while (left < right) {
            char temp = chars[left];
            chars[left++] = chars[right];
            chars[right--] = temp;
        }
    }

    public static String reverseWords(String s) {
        // Strings are immutable in java so converting it to an array
        char[] chars = s.toCharArray();
        // Assigning 2 pointers at 2 ends
        int left = 0, right = chars.length - 1;

        for (int i = 0; i < chars.length; i++) {
            // If we get a space, that means we have found a word, so we call a function to reverse the string so far
            if (chars[i] == ' ') {
                reverse(chars, left, i - 1);
                // We update our left to the index after space signifying that it is the start of the next word
                left = i + 1;
            }
        }
        // Since there are no spaces after the last word, we reverse until the end of the string
        reverse(chars, left, right);

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseWords("Let's take LeetCode contest"));
    }
}
