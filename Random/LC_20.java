// https://leetcode.com/problems/valid-parentheses/

import java.util.*;

public class LC_20 {
    public static boolean isValid(String s) {
        // Using a stack to process the string
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                // If it is an opening bracket, we add it in the stack
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    // Meaning there are no valid brackets to match our opening brackets
                    return false;
                } else if (ch == ')' && stack.peek() == '(') {
                    // If there are valid matches, we pop the stack to remove the pair of valid brackets out of consideration
                    stack.pop();
                } else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    // The current pair is invalid and we return false
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()())()()))("));
    }
}
