// https://leetcode.com/problems/reverse-string-ii/

public class LC_541 {
    public static String reverseStr(String s, int k) {
        int len = s.length();
        // If the length of the string is 1, we can't do much,
        // so we just return the same string
        if (len == 1) {
            return s;
        }

        char[] chars = s.toCharArray();

        // Our loop increases by 2 * k every iteration
        for (int i = 0; i < len; i += 2 * k) {
            // Using 2 pointers to reverse the array range
            int left = i, right = Math.min(i + k - 1, len - 1);
            while (left < right) {
                char temp = chars[left];
                chars[left] = chars[right];
                chars[right] = temp;

                left++;
                right--;
            }
        }

        return String.valueOf(chars);
    }

    public static void main(String[] args) {
        System.out.println(reverseStr("abcdefg", 2));
    }
}
