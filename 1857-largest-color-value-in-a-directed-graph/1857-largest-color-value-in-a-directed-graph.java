import java.util.*;

class Solution {

    int[] state;
    int[][] dp;
    String colors;
    ArrayList<ArrayList<Integer>> graph;

    // DFS and cycle check
    boolean dfs(int node) {

        state[node] = 1;

        for (int nei : graph.get(node)) {

            // Cycle found
            if (state[nei] == 1) {
                return false;
            }

            // Visit unvisited neighbor
            if (state[nei] == 0) {
                if (!dfs(nei)) {
                    return false;
                }
            }

            // Take best value from neighbor
            for (int c = 0; c < 26; c++) {
                dp[node][c] = Math.max(dp[node][c], dp[nei][c]);
            }
        }

        // Add current node's color
        dp[node][colors.charAt(node) - 'a']++;

        state[node] = 2;

        return true;
    }

    public int largestPathValue(String colors, int[][] edges) {

        this.colors = colors;

        int n = colors.length();

        state = new int[n];
        dp = new int[n][26];

        // Build graph
        graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
        }

        int ans = 0;

        // DFS from every node
        for (int i = 0; i < n; i++) {

            if (state[i] == 0) {

                if (!dfs(i)) {
                    return -1;
                }
            }

            // Find maximum color count
            for (int c = 0; c < 26; c++) {
                ans = Math.max(ans, dp[i][c]);
            }
        }

        return ans;
    }
}