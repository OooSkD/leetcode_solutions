package solution_643_Maximum_Average_Subarray;

public class solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg;
        double sum = 0;
        for (int right = 0; right < k; right++) {
            sum += nums[right];
        }
        maxAvg = sum / k;
        for (int right = k; right < nums.length; right++) {
            sum = sum + nums[right] -  nums[right-k];
            maxAvg = Math.max(maxAvg, sum / k);
        }
        return maxAvg;
    }
}
