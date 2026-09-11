import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        // 1. Build graph
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int source = flight[0];
            int destination = flight[1];
            int price = flight[2];

            graph.get(source).add(new int[]{destination, price});
        }

        // 2. dist[city][flightsUsed]
        int[][] dist = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // Source: cost 0, flights used 0
        dist[src][0] = 0;

        // 3. Min Heap
        // [node, cost, flightsUsed]
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[1] - b[1]
        );

        pq.offer(new int[]{src, 0, 0});

        // 4. Dijkstra-like traversal
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int node = curr[0];
            int cost = curr[1];
            int flightsUsed = curr[2];

            // Explore neighbours
            for (int[] edge : graph.get(node)) {

                int destination = edge[0];
                int price = edge[1];

                int newFlights = flightsUsed + 1;
                int newCost = cost + price;

                // Don't exceed k stops
                if (newFlights <= k + 1 &&
                    newCost < dist[destination][newFlights]) {

                    dist[destination][newFlights] = newCost;

                    pq.offer(new int[]{
                        destination,
                        newCost,
                        newFlights
                    });
                }
            }
        }

        // 5. Find cheapest valid cost to destination
        int answer = Integer.MAX_VALUE;

        for (int flightsUsed = 0; flightsUsed <= k + 1; flightsUsed++) {
            answer = Math.min(answer, dist[dst][flightsUsed]);
        }

        if (answer == Integer.MAX_VALUE) {
            return -1;
        }

        return answer;
    }
}