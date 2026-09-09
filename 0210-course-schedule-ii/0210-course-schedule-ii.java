class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        int[] inde=new int[numCourses];
        for(int[] i:prerequisites){
            int course=i[0];
            int pre=i[1];
            graph.get(pre).add(course);
            inde[course]++;

        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(inde[i]==0){
                q.offer(i);
            }
        }
        ArrayList<Integer> order=new ArrayList<>();
        while(!q.isEmpty()){
            int cur=q.poll();
            order.add(cur);
            for(int nei:graph.get(cur)){
                inde[nei]--;
                if(inde[nei]==0){
                    q.offer(nei);
                }
            }
    }
    if(order.size()!=numCourses){
         return new int[0];
    }
         // 7. Convert ArrayList<Integer> to int[]
        int[] ans = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            ans[i] = order.get(i);
        }

        return ans;
    }
}