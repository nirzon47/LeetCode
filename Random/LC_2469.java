// https://leetcode.com/problems/convert-the-temperature/

import java.util.*;

public class LC_2469 {
    public static double[] convertTemperature(double celsius) {
        double[] res = {0, 0};

        // Self explanatory code
        res[0] = celsius + 273.15;
        res[1] = celsius * 1.80 + 32.0;

        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(convertTemperature(36.50)));
    }
}
