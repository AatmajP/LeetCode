import java.util.*;

class Solution {

    int[] parent;

    // Find the root of a node
    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    // Merge two components
    void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        // Create all possible edges
        ArrayList<int[]> edges = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {

                int distance =
                    Math.abs(points[i][0] - points[j][0])
                    + Math.abs(points[i][1] - points[j][1]);

                edges.add(new int[]{i, j, distance});
            }
        }

        // Sort edges by weight
        edges.sort((a, b) -> a[2] - b[2]);

        // Initialize DSU
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int totalCost = 0;
        int edgesUsed = 0;

        // Kruskal
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            int rootU = find(u);
            int rootV = find(v);

            // Different components → take edge
            if (rootU != rootV) {

                union(u, v);

                totalCost += weight;
                edgesUsed++;

                // MST has n - 1 edges
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        return totalCost;
    }
}