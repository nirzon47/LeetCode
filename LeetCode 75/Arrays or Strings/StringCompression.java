// https://leetcode.com/problems/string-compression/

import java.util.*;

public class StringCompression {

    public static int compress(char[] chars) {
        int len = chars.length, count = 1, i;
        StringBuilder res = new StringBuilder();
        char check = chars[0];

        // If the array is just one character, return 1 and call it a day
        if (len == 1) {
            res.append(check);
            return chars.length;
        }

        // If the current character is the same as the character before it, increase the count
        // Otherwise, adds the character to the string if the count is 1, otherwise adds both the character and the count
        for (i = 1; i < len; i++) {

            if (check == chars[i]) {
                count++;
            } else {
                if (count == 1)
                    res.append((chars[i - 1]));
                else
                    res.append(chars[i - 1]).append(count);
                count = 1;
                check = chars[i];
            }
        }

        // Check or the last character since the loop exits before that
        if (chars[i - 1] == chars[i - 2]) {
            res.append(chars[i - 1]).append(count);
        } else {
            res.append(chars[i - 1]);
        }

        // Adds the res to the input array
        for (i = 0; i < res.length(); i++) {
            chars[i] = res.charAt(i);
        }

        // Returns the length of the string
        return res.length();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[] ch = new char[n];

        for (int i = 0; i < n; i++) {
            ch[i] = sc.next().charAt(0);
        }

        System.out.println(compress(ch));
    }
}
