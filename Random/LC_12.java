// https://leetcode.com/problems/integer-to-roman/

public class LC_12 {
    public static String intToRoman(int num) {
        // Making a map to the integers to their roman counterparts, some special values have like 900,
        //  400, etc. are also added
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        // Result StringBuilder
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            // If the number is bigger than the largest value, we add the roman counterpart to our result
            while (num >= values[i]) {
                res.append(roman[i]);

                // Since we added it to the result, we also subtract it
                num -= values[i];
            }
            // If the loop breaks, that means our number is smaller than the current roman-value pair, so we minimize it
        }

        return res.toString();

    }

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }
}
