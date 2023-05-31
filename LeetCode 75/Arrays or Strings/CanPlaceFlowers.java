// https://leetcode.com/problems/can-place-flowers/

import java.util.*;

public class CanPlaceFlowers {

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) {
            return true;
        }
        for (int i = 0; i < flowerbed.length; i++) {
            // If the current element is 0 and (either it is the first element or the previous element is 0) and
            // (either it is the last element or the next element is 0), decrease n.
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                n--;
                if (n == 0) {
                    return true;
                }
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] flowerbed = new int[n];

        for (int i = 0; i < n; i++) {
            flowerbed[i] = sc.nextInt();
        }

        int key = sc.nextInt();

        System.out.println(canPlaceFlowers(flowerbed, key));
    }
}
