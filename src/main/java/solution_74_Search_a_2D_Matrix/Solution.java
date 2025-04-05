package solution_74_Search_a_2D_Matrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int m = matrix.length; // количество строк
        int n = matrix[0].length; // количество столбцов
        int left = 0, right = m * n - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            // Преобразуем индекс mid в строку и столбец
            int midValue = matrix[mid / n][mid % n];

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Пример 1:
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 3;
        boolean result = solution.searchMatrix(matrix, target);
        System.out.println("Результат поиска для target = 3: " + result); // Ожидаемый результат: true

        // Пример 2:
        target = 13;
        result = solution.searchMatrix(matrix, target);
        System.out.println("Результат поиска для target = 13: " + result); // Ожидаемый результат: false
    }
}
