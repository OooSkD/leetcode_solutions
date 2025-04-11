package solution_1653_Minimum_Deletions_to_Make_Balanced;

public class Solution {
    public static int minimumDeletions(String s) {
        int countA = 0, countB = 0, minDeletions;

        // Шаг 1: считаем все 'a' (предположим, что удалим их)
        for (char c : s.toCharArray()) {
            if (c == 'a') countA++;
        }

        minDeletions = countA; // Изначально удаляем все 'a'

        // Шаг 2: Двигаем границу между 'b' и 'a'
        for (char c : s.toCharArray()) {
            if (c == 'b') countB++; // Удаляем 'b' слева
            else countA--; // Удаляем 'a' справа

            minDeletions = Math.min(minDeletions, countB + countA);
        }

        return minDeletions;
    }

    public static void main(String[] args) {
        System.out.println(minimumDeletions("aababbab")); // 2
        System.out.println(minimumDeletions("bbaaaaabb")); // 2
        System.out.println(minimumDeletions("ababab")); // 2
        System.out.println(minimumDeletions("baaaab")); // 2
    }
}
