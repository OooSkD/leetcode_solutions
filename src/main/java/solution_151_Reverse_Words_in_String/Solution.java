package solution_151_Reverse_Words_in_String;

public class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder result = new StringBuilder();
        for (int i = words.length - 1; i > 0 ; i--) {
            if (words[i].length() == 0) {
                continue;
            }
            result.append(words[i]).append(" ");
        }
        result.append(words[0]);
        return result.toString();
    }
}
