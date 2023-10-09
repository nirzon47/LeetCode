// https://leetcode.com/problems/sum-multiples/

public class LC_2652 {
    public static int sumOfMultiples(int n) {
        int sum = 0;

        // If the elements are multiples of 3, 5 and 7, they cannot be less than 3, so we start with 3,
        // and we go less than and equal to n
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                // If they are divisible, we add it to sum
                sum += i;
            }
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(sumOfMultiples(7));
    }
}
