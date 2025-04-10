package solution_1679_Max_Number_of_K_Sum_Pairs;

import java.util.HashMap;

public class Solution {

    public static int maxOperations1(int[] nums, int k) {
        java.util.Arrays.sort(nums);
        int l = 0, r = nums.length - 1, operations = 0;

        while (l < r) {
            int sum = nums[l] + nums[r];

            if (sum == k) {
                operations++;
                l++;
                r--;
            } else if (sum < k) {
                l++;
            } else {
                r--;
            }
        }
        return operations;
    }

    public static int maxOperations(int[] nums, int k) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        int operations = 0;

        for (int num : nums) {
            int complement = k - num;

            if (countMap.getOrDefault(complement, 0) > 0) {
                operations++;
                countMap.put(complement, countMap.get(complement) - 1);
            } else {
                countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            }
        }
        return operations;
    }

    public static void main(String[] args) {
        System.out.println(maxOperations1(new int[]{1, 2, 3, 4}, 5)); // 2
        System.out.println(maxOperations1(new int[]{3, 1, 3, 4, 3}, 6)); // 1
        System.out.println(maxOperations(new int[]{1, 2, 3, 4}, 5)); // 2
        System.out.println(maxOperations(new int[]{3, 1, 3, 4, 3}, 6)); // 1
    }
}
