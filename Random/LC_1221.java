// https://leetcode.com/problems/split-a-string-in-balanced-strings/

public class LC_1221 {
    public static int balancedStringSplit(String s) {
        // We can count a substring as balanced when the number of Rs and Ls are the same,
        // otherwise it is not a balanced substring
        int count = 0, res = 0;

        for (char c : s.toCharArray()) {
            // So when we get R, we increase our count
            if (c == 'R') {
                count++;
            } else {
                // And when we get L, we decrease our count
                count--;
            }

            // As soon as we get the balance, we increase our count by 1
            if (count == 0) {
                res++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLRRLLRLRL"));

    }
}
