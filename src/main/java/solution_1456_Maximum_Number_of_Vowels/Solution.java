package solution_1456_Maximum_Number_of_Vowels;

public class Solution {
    public static int maxVowels(String s, int k) {
        String vowels = "aeiou";
        int maxCount = 0, currentCount = 0;

        // Посчитаем гласные в первой подстроке длины k
        for (int i = 0; i < k; i++) {
            if (vowels.indexOf(s.charAt(i)) != -1) {
                currentCount++;
            }
        }
        maxCount = currentCount;

        // Двигаем окно
        for (int i = k; i < s.length(); i++) {
            if (vowels.indexOf(s.charAt(i - k)) != -1) currentCount--; // Убираем левый символ
            if (vowels.indexOf(s.charAt(i)) != -1) currentCount++;     // Добавляем правый символ

            maxCount = Math.max(maxCount, currentCount);
        }

        return maxCount;
    }
}
