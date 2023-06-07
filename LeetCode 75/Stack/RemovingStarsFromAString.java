// https://leetcode.com/problems/removing-stars-from-a-string/

public class RemovingStarsFromAString {

    public static String removeStars(String s) {
        int count = 0;
        StringBuilder res = new StringBuilder();
        char[] chars = s.toCharArray();

        for (int i = chars.length - 1; i >= 0; i--) {
            // If the current character is a *, increase count by one
            // If it's not, but count is more than 0, decreases count by one and that's it for the iteration
            // If it's not, but count is less than 0 or 0, append the current character to the result
            if (chars[i] == '*')
                count++;
            else {
                if (count > 0) {
                    count--;
                } else {
                    res.append(chars[i]);
                }
            }
        }
        // Since the character was iterated from the end, the result is reversed
        return res.reverse().toString();

        /*
        Stack implementation
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '*')
                stack.pop();
            else
                stack.push(c);
        }
        StringBuilder res = new StringBuilder();
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }

        return res.reverse().toString();
        */
    }

    public static void main(String[] args) {
        String s = "leet**cod*e";

        System.out.println(removeStars(s));
    }
}
