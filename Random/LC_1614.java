// https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

public class LC_1614 {
    public static int maxDepth(String s) {
        // Initialising count, count keeps track of the current nesting
        // and max keeps track of the biggest nesting
        int count = 0, max = 0;

        for (char c : s.toCharArray()) {
            if (c == '(') {
                // If the current character is an opening bracket, we increase our count;
                // means we are inside a layer of nesting
                count++;
            } else if (c == ')') {
                // If the current character is a closing bracket, we decrease the count because we are out of that nesting
                count--;
            }

            // Keep checking for the max
            max = Math.max(max, count);
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(maxDepth("(1+(2*3)+((8)/4))+1"));
    }
}
