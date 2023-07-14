// https://leetcode.com/problems/intersection-of-two-arrays/

import java.util.*;

public class LC_349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        List<Integer> list = new ArrayList<>();

        // Adding all the elements of the first array in a set to avoid duplicates
        for (int i : nums1) {
            set.add(i);
        }

        // If an element of the second array exists in the set, we
        // add it in our result array and remove it from the set .
        // This avoids duplicates
        for (int i : nums2) {
            if (set.contains(i)) {
                list.add(i);
                set.remove(i);
            }
        }

        // Turning the list into an array for returning
        int[] res = new int[list.size()];
        int pointer = 0;
        for (int i : list) {
            res[pointer++] = i;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 2, 1}, nums2 = {2, 2};
        System.out.println(Arrays.toString(intersection(nums1, nums2)));
    }
}
