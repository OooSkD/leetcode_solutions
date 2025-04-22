package solution_523_Continuous_Subarray_Sum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> remainderMap = new HashMap<>();
        remainderMap.put(0, -1); // Инициализируем остаток 0, чтобы учитывать подмассивы с начала
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int remainder = sum % k;
            if (remainder < 0) remainder += k; // Делаем остаток положительным

            if (remainderMap.containsKey(remainder)) {
                if (i - remainderMap.get(remainder) >= 2) {
                    return true;
                }
            } else {
                remainderMap.put(remainder, i);
            }
        }

        return false;
    }
}
