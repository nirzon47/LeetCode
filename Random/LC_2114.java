// https://leetcode.com/problems/maximum-number-of-words-found-in-sentences/

public class LC_2114 {
    public static int mostWordsFound(String[] sentences) {
        int max = 0;
        for (String s : sentences) {
            // Using split(" ") to separate the strings into words and then
            // comparing the length of the output array with max
            max = Math.max(max, (s.split(" ")).length);
        }

        return max;
    }

    public static void main(String[] args) {
        String[] sentences = {"alice and bob love leetcode", "i think so too", "this is great thanks very much"};
        System.out.println(mostWordsFound(sentences));
    }
}
