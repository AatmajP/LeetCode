import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char task : tasks) {
            map.put(task, map.getOrDefault(task, 0) + 1);
        }

        PriorityQueue<Integer> pq =
            new PriorityQueue<>(Collections.reverseOrder());

        pq.addAll(map.values());

        int maxF = pq.poll();

        int countM = 1;

        while (!pq.isEmpty() && pq.peek() == maxF) {
            countM++;
            pq.poll();
        }

        int total = (maxF - 1) * (n + 1) + countM;

        return Math.max(total, tasks.length);
    }
}