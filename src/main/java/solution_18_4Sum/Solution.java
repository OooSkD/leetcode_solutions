package solution_18_4Sum;

import java.util.*;

public class Solution {

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result; // Если меньше 4 элементов, возвращаем пустой список
        }

        //Arrays.sort(nums); // Сортируем массив для удобства работы с двумя указателями
        mergeSort(nums);

        for (int i = 0; i < nums.length - 3; i++) {
            // Пропускаем одинаковые элементы для первого числа
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            for (int j = i + 1; j < nums.length - 2; j++) {
                // Пропускаем одинаковые элементы для второго числа
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                int left = j + 1;
                int right = nums.length - 1;

                while (left < right) {
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // Пропускаем одинаковые элементы для третьего числа
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Пропускаем одинаковые элементы для четвертого числа
                        while (left < right && nums[right] == nums[right - 1]) right--;

                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return result;
    }

    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return; // Если массив длиной 1, он уже отсортирован
        }

        int mid = arr.length / 2;

        // Разделяем массив на две половины
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        // Рекурсивно сортируем обе половины
        mergeSort(left);
        mergeSort(right);

        // Сливаем отсортированные половины
        merge(arr, left, right);
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        // Сливаем два массива в один
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        // Добавляем оставшиеся элементы из левого массива, если они есть
        while (i < left.length) {
            arr[k++] = left[i++];
        }

        // Добавляем оставшиеся элементы из правого массива, если они есть
        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> result = fourSum(nums, target);
        System.out.println(result); // Вывод: [[-2, -1, 1, 2], [-2, 0, 0, 2], [-1, 0, 0, 1]]
    }
}

