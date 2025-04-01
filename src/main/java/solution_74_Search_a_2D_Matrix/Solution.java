package solution_74_Search_a_2D_Matrix;

public class Solution {

    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid; // Если нашли элемент, возвращаем его индекс
            }

            // Проверяем, какая половина отсортирована
            if (nums[left] <= nums[mid]) { // Левая половина отсортирована
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1; // Ищем в левой половине
                } else {
                    left = mid + 1; // Ищем в правой половине
                }
            } else { // Правая половина отсортирована
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1; // Ищем в правой половине
                } else {
                    right = mid - 1; // Ищем в левой половине
                }
            }
        }

        return -1; // Если не нашли target, возвращаем -1
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target)); // Вывод: 4
    }
}