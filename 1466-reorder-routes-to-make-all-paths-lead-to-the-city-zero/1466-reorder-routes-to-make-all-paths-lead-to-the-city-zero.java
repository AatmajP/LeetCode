import java.util.*;

class Solution {

    ArrayList<ArrayList<int[]>> graph;
    boolean[] visited;
    int ans = 0;

    void dfs(int node) {

        visited[node] = true;

        for (int[] edge : graph.get(node)) {

            int nei = edge[0];
            int cost = edge[1];

            if (!visited[nei]) {
                ans += cost;
                dfs(nei);
            }
        }
    }

    public int minReorder(int n, int[][] connections) {

        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] road : connections) {

            int u = road[0];
            int v = road[1];

            // Original direction: u -> v
            graph.get(u).add(new int[]{v, 1});

            // Reverse direction for traversal
            graph.get(v).add(new int[]{u, 0});
        }

        visited = new boolean[n];

        dfs(0);

        return ans;
    }
}