package solution_88_Merge_Sorted_Array;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int j1 = 1;
        int j2 = 1;
        int i = nums1.length - 1;
        while (i >= 0 && n - j2 >= 0 && m - j1 >= 0) {
            if (nums1[m - j1] <= nums2[n - j2]) {
                nums1[i] = nums2[n - j2];
                j2++;
            } else {
                nums1[i] = nums1[m - j1];
                j1++;
            }
            i--;
        }
        while (n - j2 >= 0) {
            nums1[i--] = nums2[n - j2];
            j2++;
        }
        while (m - j1 >= 0) {
            nums1[i--] = nums1[m - j1];
            j1++;
        }
    }
}
