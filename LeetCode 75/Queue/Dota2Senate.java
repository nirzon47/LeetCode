import java.util.*;

public class Dota2Senate {

    public static String predictPartyVictory(String senate) {
        // Creates and stores the index positions of the radiant and dire
        Queue<Integer> radiant = new LinkedList<>();
        Queue<Integer> dire = new LinkedList<>();
        char[] chars = senate.toCharArray();
        int len = chars.length;
        for (int i = 0; i < len; i++) {
            if (chars[i] == 'R')
                radiant.add(i);
            else
                dire.add(i);
        }

        // Go until one queue is empty
        while (!radiant.isEmpty() && !dire.isEmpty()) {
            // Polls both queues
            int r = radiant.poll();
            int d = dire.poll();

            // If Radiant has a higher index than dire, that means Radiant will be banned by Dire
            // but Dire will get another chance later so we add it back
            if (r > d) {
                dire.add(d + len);
            } else {
                radiant.add(r + len);
            }
        }

        // If Radiant is empty, it ran out of players, so it loses and Dire wins
        return radiant.isEmpty() ? "Dire" : "Radiant";

    }

    public static void main(String[] args) {
        String senate = "RDDDR";

        System.out.println(predictPartyVictory(senate));
    }
}
