import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // 1. Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        // 2. Get all unique numbers
        List<Integer> l = new ArrayList<>(map.keySet());

        // 3. Sort numbers by frequency (highest first)
        l.sort((a, b) -> map.get(b) - map.get(a));

        // 4. Store top K elements
        int[] res = new int[k];

        for (int i = 0; i < k; i++) {
            res[i] = l.get(i);
        }

        // 5. Return answer
        return res;
    }
}