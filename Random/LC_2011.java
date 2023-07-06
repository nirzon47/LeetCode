// https://leetcode.com/problems/final-value-of-variable-after-performing-operations/

public class LC_2011 {
    public static int finalValueAfterOperations(String[] operations) {
        int res = 0;

        for (String s : operations) {
            // We are taking the middle operator, if it is, +, we add one, otherwise we minus one
            // Middle has to be operator
            char operator = s.charAt(1);
            if (operator == '+') {
                res++;
            } else {
                res--;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        String[] operations = {"--X", "X++", "X++"};
        System.out.println(finalValueAfterOperations(operations));
    }
}
