package solution_1386_Cinema_Seat_Allocation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> seats = new HashMap<>();
        for (int[] seat : reservedSeats) {
            if (!seats.containsKey(seat[0])) {
                seats.put(seat[0], new HashSet<>());
            }
            seats.get(seat[0]).add(seat[1]);
        }
        int countGroup = (n - seats.size()) * 2;
        for (Set<Integer> reserved : seats.values()) {
            boolean left = reserved.contains(2) || reserved.contains(5)
                    || reserved.contains(3) || reserved.contains(4);
            boolean right = reserved.contains(6) || reserved.contains(7)
                    || reserved.contains(8) || reserved.contains(9);
            boolean mid = reserved.contains(4) || reserved.contains(5)
                    || reserved.contains(6) || reserved.contains(7);
            if (!left && !right) {
                countGroup += 2;
            } else if (!left || !right || !mid) {
                countGroup += 1;
            }
        }
        return countGroup;
    }
}
