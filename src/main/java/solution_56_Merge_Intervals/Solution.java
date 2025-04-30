package solution_56_Merge_Intervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        LinkedList<int[]> result = new LinkedList<>();
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (result.getLast()[1] >= intervals[i][0]) {
                result.getLast()[1] = Math.max(result.getLast()[1], intervals[i][1]);
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[result.size()][2]);
    }
}
