public class LC_1832 {
    public static dasdadadboolean checkIfPangram(String sentence) {
        int len = sentence.length();

        if (len < 26) {
            return false;
        }

        for (int i = 0; i < 26; i++) {
            char c = (char) (i + 'a');

            if (sentence.indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(checkIfPangram("thequickbrownfoxjumpedoverthelazyslowdog"));
    }
}
