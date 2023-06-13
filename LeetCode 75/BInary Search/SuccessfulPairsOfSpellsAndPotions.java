//https://leetcode.com/problems/successful-pairs-of-spells-and-potions/

import java.util.*;

public class SuccessfulPairsOfSpellsAndPotions {

    public static int[] successfulPairs(int[] spells, int[] potions, long success) {

        // Sorting the array to perform binary search
        Arrays.sort(potions);
        // Taking the lengths of spells and potions
        int spellsLen = spells.length, potionsLen = potions.length;
        // Making a result array
        int[] res = new int[spellsLen];

        // Iterating through spells[]
        for (int i = 0; i < spellsLen; i++) {
            // Taking lower bound as 'left' and upper bound as 'right'
            int left = 0, right = potionsLen;

            // Binary search will find us the element that is just under success
            while (left < right) {
                int mid = left + (right - left) / 2;
                long currValue = (long) spells[i] * (long) potions[mid];
                if (currValue >= success) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            // Adding the remaining length of the array in the result array
            res[i] = potionsLen - left;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] spells = {5, 1, 3}, potions = {1, 2, 3, 4, 5};
        int success = 7;

        System.out.println(Arrays.toString(successfulPairs(spells, potions, success)));
    }
}
