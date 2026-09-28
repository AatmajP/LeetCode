/*import java.util.*;

class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int n = graph.length;

        int[] outdegree = new int[n];

        // Reverse graph
        ArrayList<ArrayList<Integer>> reverse = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            reverse.add(new ArrayList<>());
        }

        // Build reverse graph and calculate outdegree
        for (int i = 0; i < n; i++) {

            outdegree[i] = graph[i].length;

            for (int neighbor : graph[i]) {
                reverse.get(neighbor).add(i);
            }
        }

        // Terminal nodes
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (outdegree[i] == 0) {
                q.offer(i);
            }
        }

        // Find safe nodes
        ArrayList<Integer> safe = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();

            safe.add(node);

            for (int prev : reverse.get(node)) {

                outdegree[prev]--;

                if (outdegree[prev] == 0) {
                    q.offer(prev);
                }
            }
        }

        // Problem requires sorted order
        Collections.sort(safe);

        return safe;
    }
}*/

import java.util.*;

class Solution {
    int state[];
    boolean dfs(int node,int[][] graph){
        if(state[node]==1) return false;
        if(state[node]==2) return true;
        state[node]=1;
         for (int nei : graph[node]) {
            if (!dfs(nei, graph)) return false;
        }

        state[node] = 2; // completely processed
        return true;
    
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        state=new int[n];
       List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (dfs(i, graph)) {
                answer.add(i);
            }
        }

        return answer;
    }}
