import java.util.*;

class Solution {

    int[] parent;

    public int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    public void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }

    public int makeConnected(int n, int[][] connections) {

        // Not enough cables
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];

        // Initially every computer is its own component
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] connection : connections) {

            int a = connection[0];
            int b = connection[1];

            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                union(a, b);
                components--;
            }
        }

        return components - 1;
    }
}