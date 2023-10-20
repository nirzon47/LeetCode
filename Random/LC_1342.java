// https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/

public class LC_1342 {
    public static int numberOfSteps(int num) {
        int count = 0;

        while (num != 0) {
            // We increase our step count regardless
            count++;

            // And perform the operations based on if the number is even or odd
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num -= 1;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(numberOfSteps(14));
    }
}
