import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

     /*   // 1. Build graph
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

        return answer; */









     // BELLMAN FORD METHOD
int INF = 1000000;

// Sabhi cities ko initially unreachable maan rahe hain
int[] dist = new int[n];

for (int i = 0; i < n; i++) {
    dist[i] = INF;
}

// Source city se source city tak cost 0 hoti hai
dist[src] = 0;

// Maximum flights = k + 1
for (int i = 0; i < k + 1; i++) {

    // Previous iteration ki values ko copy kar rahe hain
    // Ek iteration mein sirf ek additional flight allow hogi
    int[] temp = dist.clone();

    for (int[] fi : flights) {

        int u = fi[0];
        int v = fi[1];
        int wei = fi[2];

        // dist se read karo, temp mein update karo
        if (dist[u] != INF && dist[u] + wei < temp[v]) {
            temp[v] = dist[u] + wei;
        }
    }

    // Current iteration ka result next iteration ke liye save karo
    dist = temp;
}

// Destination unreachable hai toh -1
if (dist[dst] == INF) {
    return -1;
}

return dist[dst];
    }
}