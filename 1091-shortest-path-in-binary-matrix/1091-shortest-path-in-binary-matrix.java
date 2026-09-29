class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        int[][] dist=new int[n][n];
        dist[0][0]=1;
        if(grid[0][0]==1) return -1;
         Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});

        int[] dr = {-1,-1,-1,0,0,1,1,1};
        int[] dc = {-1,0,1,-1,1,-1,0,1};
        while(!q.isEmpty()){
            int[] cur=q.poll();
            int r=cur[0];
            int c=cur[1];

            for(int i=0;i<8;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];

                
                if (nr >= 0 && nr < n &&
                    nc >= 0 && nc < n &&
                    grid[nr][nc] == 0 &&
                    dist[nr][nc] == 0) {
                        dist[nr][nc]=dist[r][c] + 1;
                    q.offer(new int[]{nr, nc});


            }
        }
        }
     
        return dist[n-1][n-1] == 0 ? -1 : dist[n-1][n-1];
    }
}