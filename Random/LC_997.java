// https://leetcode.com/problems/find-the-town-judge/

public class LC_997 {
    public static int findJudge(int n, int[][] trust) {
        // Making a hashmap of people who trust someone and who is trusted by others
        int[] isTrusted = new int[n + 1];
        int[] trusts = new int[n + 1];

        for (int[] r : trust) {
            // populating the array according to the test case format
            trusts[r[0]]++;
            isTrusted[r[1]]++;
        }

        for (int i = 1; i <= n; i++) {
            // If the person does not trust anyone but is trusted by everyone, we found our leader
            if (trusts[i] == 0 && isTrusted[i] == n - 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findJudge(2, new int[][]{{1, 2}}));
    }
}
