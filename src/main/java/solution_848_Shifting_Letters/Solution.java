package solution_848_Shifting_Letters;

public class Solution {
    public static String shiftingLetters(String s, int[] shifts) {
        int n = s.length();
        long totalShift = 0; // Переменная для суммарного сдвига
        char[] result = s.toCharArray(); // Преобразуем строку в изменяемый массив символов

        // Идём с конца, суммируем сдвиги
        for (int i = n - 1; i >= 0; i--) {
            totalShift = (totalShift + shifts[i]) % 26; // Обновляем общий сдвиг (по модулю 26)
            result[i] = (char) ('a' + (result[i] - 'a' + totalShift) % 26); // Изменяем букву с учётом сдвига
            //не сработает для 'z';
            //result[i] = (char) (result[i] + totalShift);
        }

        return new String(result); // Возвращаем итоговую строку

    }
}
