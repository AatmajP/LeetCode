class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visit=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++){
            if(!visit[i]){
                count++;
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                visit[i] = true;
                while(!q.isEmpty()){
                    int node=q.poll();
                    for(int j=0;j<n;j++){
                        if(isConnected[node][j]==1&&!visit[j]){
                            visit[j]=true;
                            q.offer(j);
                        }
                    }
                }
            }
        }return count;
    }
}