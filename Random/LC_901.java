// https://leetcode.com/problems/online-stock-span/

import java.util.*;

public class LC_901 {
    /*
     *
     */
    static List<Integer> res = null;
    static Stack<Integer> stack = null;
    static int index = -1;

    public LC_901() {
        res = new ArrayList<>();
        stack = new Stack<>();
    }

    public static int next(int price) {
        int result = 1;
        res.add(price);
        index++;

        while (!stack.isEmpty() && res.get(stack.peek()) <= price) {
            stack.pop();
        }

        if (stack.isEmpty()) {
            result = index + 1;
        } else {
            result = index - stack.peek();
        }

        stack.push(index);

        return result;
    }

    public static void main(String[] args) {
        LC_901 obj = new LC_901();
        int price = 10;
        int param_1 = next(price);
        System.out.println(param_1);
    }
}
