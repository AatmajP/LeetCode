class Solution {
    public int swimInWater(int[][] grid) {
        int row=grid.length;
        int col=grid[0].length;
        int[][] dist=new int[row][col];
        for(int i=0;i<row;i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }
        dist[0][0]=grid[0][0];
      // Min Heap based on effort/water level
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[2] - b[2]
        );

        // {row, column, current maximum water level}
        pq.offer(new int[]{0, 0, grid[0][0]});

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while(!pq.isEmpty()){
            int[] cell=pq.poll();
            int r=cell[0];
            int c=cell[1];
            int effort=cell[2];
            if(r==row-1&&c==col-1){
                return effort;
            }
            for(int d=0;d<4;d++){
                int nr=r+dr[d];
                int nc=c+dc[d];
                if(nr>=0&&nr<row&&nc>=0&&nc<col){
                     int newEffort = Math.max(
                        effort,
                        grid[nr][nc]);
                        if (newEffort < dist[nr][nc]) {

                        dist[nr][nc] = newEffort;

                        pq.offer(new int[]{
                            nr,
                            nc,
                            newEffort
                        });
                        }
                }
                }
            }
            
            
        return -1;
    }
}