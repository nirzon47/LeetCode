// https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/

import java.util.*;

public class KidsWithTheGreatestNumberOfCandies {

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> res = new ArrayList<>();

        // Finding the max without any candies added.
        int maxWithoutExtra = Integer.MIN_VALUE;
        for (int j : candies) {
            maxWithoutExtra = Math.max(maxWithoutExtra, j);
        }

        // Adding boolean to the list if the extra candies with existing candies is more than the maxWithoutExtra or not
        for (int candy : candies) {
            if (candy + extraCandies >= maxWithoutExtra)
                res.add(true);
            else
                res.add(false);
        }
        
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] candies = new int[n];

        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
        }

        int extraCandies = sc.nextInt();

        System.out.println(kidsWithCandies(candies, extraCandies));
    }
}
