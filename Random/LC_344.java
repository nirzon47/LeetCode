// https://leetcode.com/problems/reverse-string/

public class LC_344 {
    public static void reverseString(char[] s) {
        // Using two pointers to reverse the array
        int left = 0, right = s.length - 1;

        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        char[] word = {'h', 'e', 'l', 'l', 'o'};

        reverseString(word);

        System.out.println(String.valueOf(word));
    }
}
