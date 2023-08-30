// https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/

public class LC_1963 {
    public static int minSwaps(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If we get an opening bracket, we increase the count
            if (c == '[') {
                count++;
            } else if (count > 0) {
                // If we are here, then it means that the current character is a closing bracket
                // And we are also checking if we have an opening bracket for the closing bracket,
                // if we do, we close off that pair
                count--;
            }
        }

        // Now the count is the ceil of count / 2 because we are fixing two spots at once
        return (count + 1) / 2;
    }

    public static void main(String[] args) {
        System.out.println(minSwaps("][]["));
    }
}
