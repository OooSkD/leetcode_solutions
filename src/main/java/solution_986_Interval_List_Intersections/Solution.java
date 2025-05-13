package solution_986_Interval_List_Intersections;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int index1 = 0;
        int index2 = 0;
        List<int[]> result = new ArrayList<>();
        while(index1 < firstList.length && index2 < secondList.length) {
            int start = Math.max(firstList[index1][0], secondList[index2][0]);
            int end = Math.min(firstList[index1][1], secondList[index2][1]);
            if (start <= end) {
                result.add(new int[]{start, end});
            }
            if (firstList[index1][1] < secondList[index2][1]) {
                index1++;
            } else {
                index2++;
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
