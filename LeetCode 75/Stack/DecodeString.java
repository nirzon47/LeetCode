// https://leetcode.com/problems/decode-string/

import java.util.*;

public class DecodeString {

    public static String decodeString(String s) {
        // numStack holds the number of supposed repetitions
        Stack<Integer> numStack = new Stack<>();
        // stringStack holds the characters thus far
        Stack<StringBuilder> stringStack = new Stack<>();
        int count = 0;
        // res holds the partial characters till it encounters ]
        // until which it contains the partial set of characters
        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            // If the current character is a number, adds it to the count using standard *10+r method
            if (ch >= '0' && ch <= '9') {
                count = count * 10 + ch - '0';
            }
            // If the current character is a '[', pushes the count thus far and the characters encountered
            // thus far into stacks
            else if (ch == '[') {
                numStack.push(count);
                count = 0;
                stringStack.push(res);
                res = new StringBuilder();
            }
            // If the current character is a ']', takes the popped number from numStack into i
            // Also stores the partial set of alphabets stored so far into a temporary variable
            // Pops the stringStack (the output so far) into the res variable
            // Adds the alphabets stored in the temporary variable i times
            else if (ch == ']') {
                int i = numStack.pop();
                StringBuilder temp = res;
                res = stringStack.pop();
                res.append(String.valueOf(temp).repeat(i));
            }
            // If the character is an alphabet, simply appends it to the result
            else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        String s = "3[a]2[bc]";

        System.out.println(decodeString(s));
    }
}
