package solution_5_Longest_Palindromic_Substring;

public class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        String sProcessed = processed(s);
        int n = sProcessed.length();
        int[] radius = new int[n];
        int center = 0, rightBorder = 0;
        int maxLength = 0, maxCenterIndex = 0;
        for (int i = 0; i < n; i++) {
            int mirror = 2 * center - i;
            if (i < rightBorder) {
                radius[i] = Math.min(rightBorder - i, radius[mirror]);
            }

            while (i + radius[i] + 1 < n &&
                    i - radius[i] - 1 >= 0 &&
                    sProcessed.charAt(i + radius[i] + 1) == sProcessed.charAt(i - radius[i] - 1)) {
                radius[i]++;
            }

            if (radius[i] + i > rightBorder) {
                rightBorder = radius[i];
                center = i;
            }

            if (radius[i] > maxLength) {
                maxLength = radius[i];
                maxCenterIndex = i;
            }

        }
        int start = (maxCenterIndex - maxLength) / 2;
        return s.substring(start, start + maxLength);
    }

    private static String processed(String s) {
        StringBuilder result = new StringBuilder("#");
        for (char c : s.toCharArray()) {
            result.append(c).append('#');
        }
        return result.toString();
    }
}
