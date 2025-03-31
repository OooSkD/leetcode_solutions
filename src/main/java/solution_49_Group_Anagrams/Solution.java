package solution_49_Group_Anagrams;
import java.util.*;

public class Solution {
    public static List<List<String>> groupAnagrams(String[] strs) {

        // Хэш-таблица для хранения групп анаграмм
        Map<String, List<String>> map = new HashMap<>();

        // Обрабатываем каждую строку из массива
        for (String str : strs) {
            /*
            // Преобразуем строку в массив символов, сортируем и возвращаем обратно в строку
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortedStr = new String(chars);
            */

            String sortedStr = countingSort(str);


            // Если такой ключ уже есть, добавляем строку в соответствующую группу
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            map.get(sortedStr).add(str);
        }

        // Возвращаем все группы анаграмм
        return new ArrayList<>(map.values());
    }

    // Сортировка подсчетом для строки (O(M))
    private static String countingSort(String s) {
        int[] count = new int[26]; // Частотный массив для букв a-z

        for (char c : s.toCharArray()) {
            count[c - 'a']++; // Заполняем частоты
        }

        StringBuilder sorted = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0) {
                sorted.append((char) ('a' + i)); // Восстанавливаем отсортированную строку
                count[i]--;
            }
        }

        return sorted.toString();
    }

    public static void main(String[] args) {
        // Создание экземпляра решения
        Solution solution = new Solution();

        // Пример входных данных
        String[] strs = {"eaat", "teaa", "taan", "aate", "naat", "baat"};

        // Вызов метода groupAnagrams
        List<List<String>> result = solution.groupAnagrams(strs);

        // Вывод результата
        System.out.println("Группы анаграмм:");
        for (List<String> group : result) {
            System.out.println(group);
        }
    }
}
