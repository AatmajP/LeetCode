import java.util.*;

class Solution {

    int[] state;
    int[] time;
    int[] edges;
    int[] visitId;

    // DFS for finding a cycle
    int dfs(int node, int step, int id) {

        // Mark node as visiting
        state[node] = 1;

        // Store when we reached this node
        time[node] = step;

        // Store which DFS this node belongs to
        visitId[node] = id;

        int next = edges[node];

        // No next node
        if (next == -1) {
            state[node] = 2;
            return -1;
        }

        // Cycle found in current DFS
        if (state[next] == 1 && visitId[next] == id) {
            return step + 1 - time[next];
        }

        // Visit next node
        if (state[next] == 0) {

            int res = dfs(next, step + 1, id);

            if (res != -1) {
                return res;
            }
        }

        // Done with this node
        state[node] = 2;

        return -1;
    }

    public int longestCycle(int[] edges) {

        this.edges = edges;

        int n = edges.length;

        state = new int[n];
        time = new int[n];
        visitId = new int[n];

        int ans = -1;

        // Start DFS from every unvisited node
        for (int i = 0; i < n; i++) {

            if (state[i] == 0) {

                int cycle = dfs(i, 0, i);

                ans = Math.max(ans, cycle);
            }
        }

        return ans;
    }
}