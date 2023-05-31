// https://leetcode.com/problems/reverse-words-in-a-string/

import java.util.*;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        // Taking a string for each individual word
        StringBuilder word = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (i == 0) {
                // If the first character is not a space, append it, otherwise don't
                if (s.charAt(i) != ' ')
                    word.append(s.charAt(i));
                res.append(word.reverse());
                break;
            } else if (s.charAt(i) != ' ') { // If the character is not a space, append it to the word.
                word.append(s.charAt(i));
            } else {
                if (s.charAt(i - 1) == ' ' || word.length() == 0)
                    // If the length of the word is 0 in case where there are 2 spaces back to back or the character before the current
                    // character is also a space, skips the current iteration, otherwise append the word with a space and resets word.
                    continue;
                res.append(word.reverse()).append(' ');
                word.setLength(0);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        System.out.println(reverseWords(s));
    }
}
