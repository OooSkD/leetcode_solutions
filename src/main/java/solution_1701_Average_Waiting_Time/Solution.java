package solution_1701_Average_Waiting_Time;

public class Solution {
    public static double averageWaitingTime(int[][] customers) {
        long currentTime = 0, totalWaitTime = 0;

        for (int[] customer : customers) {
            int arrival = customer[0], cookTime = customer[1];

            // Если повар свободен позже прибытия клиента, он должен подождать
            currentTime = Math.max(currentTime, arrival) + cookTime;

            // Время ожидания = когда заказ был закончен - время прибытия
            totalWaitTime += (currentTime - arrival);
        }

        return (double) totalWaitTime / customers.length;
    }

    public static void main(String[] args) {
        int[][] customers1 = {{1, 2}, {2, 5}, {4, 3}};
        System.out.println(averageWaitingTime(customers1)); // 5.0

        int[][] customers2 = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        System.out.println(averageWaitingTime(customers2)); // 3.25
    }
}
