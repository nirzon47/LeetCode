// https://leetcode.com/problems/destroying-asteroids/description/

import java.util.*;

public class LC_2126 {
    public static boolean asteroidsDestroyed(int mass, int[] asteroids) {
        // Could be done with min heap as well
        // Sorting the array in ascending order
        Arrays.sort(asteroids);
        long sum = mass;

        for (int asteroid : asteroids) {
            // Continuing prefix sum until the sum is greater than and equal to the asteroids
            if (sum >= asteroid) {
                sum += asteroid;
            } else {
                // When any asteroid is bigger than the combined sum so far, we return false
                return false;
            }
        }

        // If the sum is bigger than all asteroids, we return true
        return true;
    }

    public static void main(String[] args) {
        int mass = 10;
        int[] asteroids = {3, 9, 19, 5, 21};

        System.out.println(asteroidsDestroyed(mass, asteroids));
    }
}
