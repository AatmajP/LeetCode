import java.util.*;

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] i : times) {
            int source = i[0];
            int dest = i[1];
            int weight = i[2];

            graph.get(source).add(new int[]{dest, weight});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {

            int[] cell = pq.poll();

            int node = cell[0];
            int distance = cell[1];

            if (distance > dist[node]) {
                continue;
            }

            for (int[] edge : graph.get(node)) {

                int nei = edge[0];
                int weight = edge[1];

                int newDist = distance + weight;

                if (newDist < dist[nei]) {
                    dist[nei] = newDist;
                    pq.offer(new int[]{nei, newDist});
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            answer = Math.max(answer, dist[i]);
        }

        return answer;
    }
}