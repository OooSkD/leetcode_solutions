package solution_1248_Count_Number_of_Nice_Subarrays;

public class Solution {
    public static int numberOfSubarrays(int[] nums, int k) {
        int left = 0, count = 0, result = 0;
        int oddCount = 0; // Количество нечетных в окне

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] % 2 == 1) { // Если число нечетное
                oddCount++;
                count = 0; // Сбросить счетчик подмассивов
            }

            while (oddCount == k) {
                if (nums[left] % 2 == 1) oddCount--; // Уменьшаем нечетные
                left++;
                count++; // Кол-во способов сузить окно
            }

            result += count; // Подсчет всех возможных подмассивов
        }

        return result;

    }
}
