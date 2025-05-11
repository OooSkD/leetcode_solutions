package solution_443_String_Compression;

public class Solution {
    public int compress(char[] chars) {
        int i = 0;
        int j = 0;
        char currentChar;
        int countChar = 0;
        while (i < chars.length) {
            currentChar = chars[i];
            countChar = 0;
            while (i < chars.length && currentChar == chars[i]) {
                countChar++;
                i++;
            }
            chars[j++] = currentChar;
            if (countChar > 1) {
                for(char c : String.valueOf(countChar).toCharArray()) {
                    chars[j++] = c;
                }
            }
        }
        return j;
    }
}
