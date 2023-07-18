// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/

public class LC_1047 {
    public static String removeDuplicates(String s) {
        // Using StringBuilder as a stack
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            int len = res.length();
            if (len != 0 && ch == res.charAt(len - 1)) {
                // If the length of our StringBuilder is not 0, and the current character
                // in the string is equal to the last character
                // in our StringBuilder, we remove the last character in the StringBuilder
                res.deleteCharAt(len - 1);
            } else {
                // Otherwise append the character in the StringBuilder
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }
}
