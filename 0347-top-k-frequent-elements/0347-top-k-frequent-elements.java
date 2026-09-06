import java.util.*;

/*class Solution {
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
}*/

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Step 1: Count frequency
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Step 2: Min Heap based on frequency
        PriorityQueue<Integer> pq =
            new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        // Step 3: Keep only K most frequent elements
        for (int num : map.keySet()) {

            pq.offer(num);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        // Step 4: Create result
        int[] result = new int[k];

        for (int i = 0; i < k; i++) {
            result[i] = pq.poll();
        }

        return result;
    }
}