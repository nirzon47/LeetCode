// https://leetcode.com/problems/find-the-highest-altitude/

public class FindTheHighestAltitude {

    public static int largestAltitude(int[] gain) {
        int highest = 0, currentAltitude = 0;

        // Compares current overall altitude with the highest altitude thus far
        for (int altitude : gain) {
            currentAltitude += altitude;
            highest = Math.max(highest, currentAltitude);
        }

        return highest;
    }

    public static void main(String[] args) {
        int[] gain = {-4, -3, -2, -1, 4, 3, 2};

        System.out.println(largestAltitude(gain));
    }
}
