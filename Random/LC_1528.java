// https://leetcode.com/problems/shuffle-string/

public class LC_1528 {
    public static String restoreString(String s, int[] indices) {
        int pointer = 0;
        // We make a new char array of similar length
        char[] res = new char[indices.length];

        for (int i : indices) {
            // Inside res's indice's index, we add the characters going from first to last
            res[i] = s.charAt(pointer++);
        }

        return new String(res);
    }

    public static void main(String[] args) {
        System.out.println(restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
    }
}
