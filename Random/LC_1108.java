// https://leetcode.com/problems/defanging-an-ip-address/

public class LC_1108 {
    public static String defangIPaddr(String address) {
        StringBuilder res = new StringBuilder();

        for (char ch : address.toCharArray()) {
            // When we encounter a period, we append our result with "[.]",
            // otherwise we append it with the character we have
            if (ch == '.') {
                res.append("[.]");
            } else {
                res.append(ch);
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(defangIPaddr("255.100.50.0"));
    }
}
