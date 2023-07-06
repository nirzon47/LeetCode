// https://leetcode.com/problems/goal-parser-interpretation/

public class LC_1678 {
    public static String interpret(String command) {
        StringBuilder res = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {
            // If our character is G, we just
            if (command.charAt(i) == 'G') {
                res.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    res.append("o");
                    i++;
                } else {
                    res.append("al");
                    i += 3;
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(interpret("G()(al)"));
    }
}
