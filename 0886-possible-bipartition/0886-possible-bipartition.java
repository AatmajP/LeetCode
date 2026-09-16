import java.util.*;

class Solution {

    int[] color;
    ArrayList<ArrayList<Integer>> graph;

    boolean dfs(int node) {

        for (int nei : graph.get(node)) {

            if (color[nei] == -1) {

                color[nei] = 1 - color[node];

                if (!dfs(nei)) {
                    return false;
                }

            } else if (color[nei] == color[node]) {

                return false;
            }
        }

        return true;
    }

    public boolean possibleBipartition(int n, int[][] dislikes) {

        graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] dis : dislikes) {

            int u = dis[0];
            int v = dis[1];

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        color = new int[n + 1];
        Arrays.fill(color, -1);

        for (int i = 1; i <= n; i++) {

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