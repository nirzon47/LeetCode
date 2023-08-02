// https://leetcode.com/problems/baseball-game/

import java.util.*;

public class LC_682 {
    public static int calPoints(String[] operations) {
        // Putting the numbers in stack, and when we get something else,
        // we do an operation using that character
        Stack<Integer> stack = new Stack<>();

        for (String operation : operations) {
            switch (operation) {
                // Taking the last 2 numbers in the stack and adding the sum of them back in the stack
                case "+" -> {
                    int n = stack.pop();
                    int m = stack.peek();
                    stack.push(n);

                    stack.push(m + n);
                }
                // Pushing the last element multiplied by 2
                case "D" -> stack.push(stack.peek() * 2);
                // Removing the last element
                case "C" -> stack.pop();
                // The rest is supposed to be a number so we convert the string to integer
                default -> stack.push(Integer.parseInt(operation));
            }
        }

        int res = 0;
        // Returning the sum of the elements in the stack
        while (!stack.isEmpty()) {
            res += stack.pop();
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(calPoints(new String[]{"5", "2", "C", "D", "+"}));
    }
}
