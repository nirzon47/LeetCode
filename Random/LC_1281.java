// https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/

public class LC_1281 {
    public static int subtractProductAndSum(int n) {
        // We used % 10 to get the last digit
        // and / 10 to remove the last digit from the number
        int prod = 1, sum = 0;

        while (n > 0) {
            prod *= n % 10;
            sum += n % 10;
            n /= 10;
        }

        return prod - sum;
    }

    public static void main(String[] args) {
        System.out.println(subtractProductAndSum(234));
    }
}
