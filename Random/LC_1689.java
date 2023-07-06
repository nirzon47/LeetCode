// https://leetcode.com/problems/partitioning-into-minimum-number-of-deci-binary-numbers/

public class LC_1689 {
    public static int minPartitions(String n) {
        // The maximum number in the string is our result because we have to add up to the number by using 11s
        int max = 0;
        for (int i : n.toCharArray()) {
            max = Math.max(max, i - '0');
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(minPartitions("82734"));
    }
}
