package solution_8_String_to_Integer;

public class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        int i = 0;
        int sign = 1;
        while (i < s.length() && s.charAt(i) == ' ') {
            i++;
        }

        if (i < s.length() && (s.charAt(i) == '-' || s.charAt(i) == '+')) {
            sign = s.charAt(i) == '-' ? -1 : 1;
            i++;
        }

        while (i < s.length() && Character.isDigit(s.charAt(i))) {
            int currentDigit = s.charAt(i) - '0';
            if (result > (Integer.MAX_VALUE - currentDigit) / 10) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            result = result * 10 + currentDigit; //<= Integer.MAX_VALUE
            i++;
        }

        return result * sign;
    }
}
