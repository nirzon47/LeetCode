// https://leetcode.com/problems/count-odd-numbers-in-an-interval-range/

public class LC_1523 {
    public static int countOdds(int low, int high) {
        // We find out the count of numbers in the range first
        int nums = high - low + 1;

        // If both low and high are odd, we do a ceil division
        if (high % 2 != 0 && low % 2 != 0) {
            return nums / 2 + 1;
        }

        // If both are even or one is even and another is odd,
        // we just return the floor division of the count of numbers
        return nums / 2;
    }

    public static void main(String[] args) {
        System.out.println(countOdds(3, 7));
    }
}
