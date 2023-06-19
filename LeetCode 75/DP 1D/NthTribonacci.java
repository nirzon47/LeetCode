// https://leetcode.com/problems/n-th-tribonacci-number/

public class NthTribonacci {

    public static int tribonacci(int n) {
        int a = 0, b = 0, c = 1, d;
        while (n-- > 0) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return b;
    }

    public static void main(String[] args) {
        int n = 25;

        System.out.println(tribonacci(n));
    }
}
