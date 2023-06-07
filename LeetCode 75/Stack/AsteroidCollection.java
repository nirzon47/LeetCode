// https://leetcode.com/problems/asteroid-collision/

import java.util.*;

public class AsteroidCollection {

    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;

        while (i < asteroids.length) {
            // If stack is empty, push an asteroid in and move on to the next one
            if (stack.isEmpty()) {
                stack.push(asteroids[i]);
                i++;
            } else {
                int last = stack.peek(); // Taking the latest element in the stack
                // We are assuming that the elements we are storing in the stack are positive
                // meaning that they are moving to the right
                // So if the next element is moving to the left, collision is due
                if (last > 0 && asteroids[i] < 0) {
                    // Both the asteroids are the same size so both go boom
                    if (Math.abs(asteroids[i]) == last) {
                        stack.pop();
                        i++;
                    }
                    // The current asteroid is bigger so the one in the stack go pop
                    else if (Math.abs(asteroids[i]) > last) {
                        stack.pop();
                    }
                    // The current one is smaller, so we just imagine it doesn't exist and move on
                    else if (Math.abs(asteroids[i]) < last) {
                        i++;
                    }
                }
                // If there is no collision, they both live, and we move on to the next iteration
                else {
                    stack.push(asteroids[i]);
                    i++;
                }
            }
        }

        // Putting the stack from the backwards for correct formatting, and so we can return the result.
        int len = stack.size();
        int[] res = new int[len];
        for (i = len - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }


    public static void main(String[] args) {
        int[] asteroids = {5, 10, -5};

        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }
}
