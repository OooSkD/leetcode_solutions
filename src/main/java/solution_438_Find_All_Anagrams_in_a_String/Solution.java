package solution_438_Find_All_Anagrams_in_a_String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        int[] freqP = new int[26], freqS = new int[26];

        // Заполняем частотный массив p
        for (char c : p.toCharArray()) freqP[c - 'a']++;

        // Перебираем s скользящим окном
        for (int i = 0; i < s.length(); i++) {
            freqS[s.charAt(i) - 'a']++; // Добавляем текущий символ в окно

            if (i >= p.length()) {
                freqS[s.charAt(i - p.length()) - 'a']--; // Убираем старый символ
            }

            if (Arrays.equals(freqP, freqS)) {
                result.add(i - p.length() + 1); // Добавляем начальный индекс
            }
        }

        return result;
    }
}
