// https://leetcode.com/problems/append-k-integers-with-minimal-sum/

import java.util.*;

public class LC_2195 {
    public static long minimalKSum(int[] nums, int k) {
        // Sort the array
        Arrays.sort(nums);
        HashSet<Integer> set = new HashSet<>();
        long sum = 0;

        // Traverse the array
        for (int num : nums) {
            // If the element in the array is not in the hash set,
            // and the element is less than equal to k
            // Increase k and add the element to the sum
            if (!set.contains(num) && num <= k) {
                k++;
                sum += num;
            }
            // Add the element in the set regardless
            set.add(num);
        }

        // We take the sum of all the numbers in the array in [1,k] and
        // increase our k according to the number of elements in that range
        // Then use the n(n+1)/2 formula on k and remove all the elements in that range
        // from that formula
        return (long) (1 + k) * k / 2 - sum;
    }

    public static void main(String[] args) {
        int[] nums = {1, 4, 25, 10, 25};
        int k = 2;

        System.out.println(minimalKSum(nums, k));
    }
}
