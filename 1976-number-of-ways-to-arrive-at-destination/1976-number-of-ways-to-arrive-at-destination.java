import java.util.*;

class Solution {
    public int countPaths(int n, int[][] roads) {

        // Har city ke liye ek list banayenge
        // graph[node] mein uske neighbors aur travel time store hoga
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();

        // Har city ke liye empty list create karo
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Roads undirected hain
        // Matlab u se v bhi ja sakte hain aur v se u bhi
        for (int[] road : roads) {

            int u = road[0];
            int v = road[1];
            int time = road[2];

            // [neighbor, time] store kar rahe hain
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        // dist[i] = city 0 se city i tak ka shortest time
        long[] dist = new long[n];

        // ways[i] = city 0 se city i tak shortest path ke kitne ways hain
        long[] ways = new long[n];

        // Initially sab cities unreachable hain
        Arrays.fill(dist, Long.MAX_VALUE);

        // Initially kisi city tak koi way nahi hai
        Arrays.fill(ways, 0);

        // Starting city 0 hai
        // 0 tak pahunchne ka distance 0 hai
        dist[0] = 0;

        // Starting point par already present hone ka 1 way hai
        ways[0] = 1;

        // Dijkstra ke liye Min Heap
        // Har element [node, distance] hoga
        PriorityQueue<long[]> pq =
            new PriorityQueue<>(
                (a, b) -> Long.compare(a[1], b[1])
            );

        // Starting city ko heap mein daalo
        pq.offer(new long[]{0, 0});

        // Answer ko MOD ke andar rakhna hai
        int MOD = 1_000_000_007;

        // Jab tak heap empty nahi hota
        while (!pq.isEmpty()) {

            // Sabse chhota distance wala node nikalo
            long[] curr = pq.poll();

            int node = (int) curr[0];
            long dis = curr[1];

            // Agar ye purana/stale distance hai,
            // to isko ignore karo
            if (dis > dist[node]) {
                continue;
            }

            // Current node ke saare neighbors check karo
            for (int[] edge : graph.get(node)) {

                int neighbor = edge[0];
                int time = edge[1];

                // Current node tak ka distance
                // + current edge ka time
                long newDist = dis + time;

                // CASE 1:
                // Humein ek SHORTER path mil gaya
                if (newDist < dist[neighbor]) {

                    // Shortest distance update karo
                    dist[neighbor] = newDist;

                    // Purane ways hata do
                    // Ab shortest path current node ke ways se aayega
                    ways[neighbor] = ways[node];

                    // New shortest distance ko heap mein daalo
                    pq.offer(new long[]{neighbor, newDist});
                }

                // CASE 2:
                // Ek AUR path mila jo same shortest distance ka hai
                else if (newDist == dist[neighbor]) {

                    // Naye ways ko existing ways mein add karo
                    ways[neighbor] =
                        (ways[neighbor] + ways[node]) % MOD;
                }
            }
        }

        // Last city tak pahunchne ke shortest ways return karo
        return (int) ways[n - 1];
    }
}