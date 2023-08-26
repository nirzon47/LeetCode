// https://leetcode.com/problems/find-the-maximum-achievable-number/

public class LC_2769 {
    public static int theMaximumAchievableX(int num, int t) {
        // Its simple formulaic question
        //    num + t = res - t
        // => res = num + 2t
        return num + (t * 2);
    }

    public static void main(String[] args) {
        System.out.println(theMaximumAchievableX(4, 1));
    }
}
