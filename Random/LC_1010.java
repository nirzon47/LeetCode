// https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/

public class LC_1010 {
    public static int numPairsDivisibleBy60(int[] time) {
        // Just like 2-sum, we are keeping the records of elements we have so far
        // if we find a pair, we work around it

        // because we are to make pairs which add up to 60's multiples, we are keeping
        // elements from 0 to 59
        int[] remainders = new int[60];
        int res = 0;

        for (int t : time) {
            // If 60 - t % 60 exists, we have a pair, and since there can be multiple pairings,
            // we take the current number of pairs we can make
            // which is also the frequency of the element
            // so we just add it in our res
            res += remainders[(60 - t % 60) % 60];
            remainders[t % 60]++;
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
    }
}
