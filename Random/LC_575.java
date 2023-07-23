// https://leetcode.com/problems/distribute-candies/

import java.util.*;

public class LC_575 {
    public static int distributeCandies(int[] candyType) {
        // We first find out the maximum number of candies she can eat
        int maxCandies = candyType.length / 2;

        // Making a set since Alice can only eat one of each type of sweets
        Set<Integer> set = new HashSet<>();

        for (int type : candyType) {
            set.add(type);
        }

        // Since the result can be either each type of candy
        // or the maximum number of candies in case n / 2 is the result,
        // we return the minimum among them
        return Math.min(set.size(), maxCandies);
    }

    public static void main(String[] args) {
        int[] candyType = {1, 1, 2, 2, 3, 3};
        System.out.println(distributeCandies(candyType));
    }
}
