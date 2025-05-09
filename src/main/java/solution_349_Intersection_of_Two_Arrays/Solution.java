package solution_349_Intersection_of_Two_Arrays;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> temp = new HashSet<>();
        addAllToSet(temp, nums1);
        Set<Integer> result = new HashSet<>();
        for (int i=0; i < nums2.length; i++) {
            if (temp.contains(nums2[i])) {
                result.add(nums2[i]);
            }
        }
        return addAllToArray(result);
    }

    private void addAllToSet(Set<Integer> temp, int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            temp.add(nums[i]);
        }
    }

    private int[] addAllToArray(Set<Integer> temp) {
        int[] result = new int[temp.size()];
        int i = 0;
        for (Integer digit : temp) {
            result[i] = digit;
            i++;
        }
        return result;
    }
}
