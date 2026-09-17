/*class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        int[] inde = new int[numCourses];

        for (int[] i : prerequisites) {
            int course = i[0];
            int pre = i[1];

            graph.get(pre).add(course);
            inde[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inde[i] == 0) {
                q.offer(i);
            }
        }

        int count = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();
            count++;

            for (int nei : graph.get(cur)) {
                inde[nei]--;

                if (inde[nei] == 0) {
                    q.offer(nei);
                }
            }
        }

        return count == numCourses;
    }
}*/

// this is dfs method

class Solution {
    ArrayList<ArrayList<Integer>> graph;
    int[] state;
    boolean dfs(int node){
        state[node]=1; 
        for(int nei:graph.get(node)){
            if(state[nei]==1) return false;
            if(state[nei]==0){
                if(!dfs(nei)) return false;
            }
        }
        state[node]=2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] pre:prerequisites){
            int a=pre[0];
            int b=pre[1];
            graph.get(b).add(a);

        }
         state = new int[numCourses];

        // Check every component
        for (int i = 0; i < numCourses; i++) {

            if (state[i] == 0) {

                if (!dfs(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}