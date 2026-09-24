class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] reach=new boolean[numCourses][numCourses];
        for(int[] ed:prerequisites){
            int u=ed[0];
            int v=ed[1];
            reach[u][v]=true;
        }
        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    if(reach[i][k]&&reach[k][j]){
                        reach[i][j]=true;
                    }
                }
            }
        }
        List<Boolean> ans=new ArrayList<>();
        for(int[] qr:queries){
            int u=qr[0];
            int v=qr[1];
            ans.add(reach[u][v]);

        }
        return ans;
    }
}