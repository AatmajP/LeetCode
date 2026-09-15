import java.util.*;

class Solution {

    int[] color;
    int[][] graph;

    boolean dfs(int node) {

        for (int neighbor : graph[node]) {

            if (color[neighbor] == -1) {

                color[neighbor] = 1 - color[node];

                if (!dfs(neighbor)) {
                    return false;
                }

            } else if (color[neighbor] == color[node]) {

                return false;
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {

        this.graph = graph;

        int n = graph.length;

        color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {

            if (color[i] == -1) {

                color[i] = 0;

                if (!dfs(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}