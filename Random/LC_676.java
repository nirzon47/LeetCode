// https://leetcode.com/problems/implement-magic-dictionary/

public class LC_676 {
    // Taking the given words and making it global so we can use it everywhere else
    String[] words;

    public static void main(String[] args) {
        LC_676 obj = new LC_676();
        obj.buildDict(new String[]{"hello", "leetcode"});
        System.out.println(obj.search("hello"));
        System.out.println(obj.search("hhllo"));
        System.out.println(obj.search("hell"));
        System.out.println(obj.search("leetcoded"));
    }

    public void buildDict(String[] dictionary) {
        // Made global
        words = dictionary;
    }

    public boolean search(String searchWord) {
        int len = searchWord.length();
        boolean res = false;

        // Matching all words in the String array with our searchWord
        for (String word : words) {
            // If the lengths are different or the words are same, then we cannot match
            if (word.length() != len || word.equals(searchWord)) {
                continue;
            }

            // Taking count as a metric for how many characters are mismatched
            int count = 0;
            for (int i = 0; i < len; i++) {
                char searchCharacter = searchWord.charAt(i);
                char wordCharacter = word.charAt(i);
                if (searchCharacter != wordCharacter) {
                    count++;
                }

                // If we have more than 1 character mismatched, we exit out of the loop
                if (count > 1) {
                    break;
                }
            }

            // If the count is 1, we make res as true
            if (count == 1) {
                res = true;
                break;
            }
        }

        return res;
    }
}
