// https://leetcode.com/problems/smallest-even-multiple/

public class LC_2413 {
    public static int smallestEvenMultiple(int n) {
        // If n is even, we return the number itself otherwise, we multiply it with 2
        return n % 2 == 0 ? n : n * 2;
    }

    public static void main(String[] args) {
        System.out.println(smallestEvenMultiple(6));
    }
}
