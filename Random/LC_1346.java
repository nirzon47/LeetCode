// https://leetcode.com/problems/check-if-n-and-its-double-exist/

import java.util.*;

public class LC_1346 {
    public static boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        for (int e : arr) {
            // Adding the elements in the set,
            // If the set contains an element double or half of it, we return true
            // We need to find if the division is clean or not, so we verify using modulo
            if (set.contains(e * 2) || (set.contains(e / 2) && e % 2 == 0)) {
                return true;
            }

            set.add(e);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[]{10, 2, 5, 3}));
    }
}
