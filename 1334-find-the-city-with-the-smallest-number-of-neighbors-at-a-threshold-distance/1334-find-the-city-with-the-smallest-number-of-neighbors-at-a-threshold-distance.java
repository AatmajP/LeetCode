class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int inf=1000000;
        int[][] dist=new int[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i],inf);
            dist[i][i]=0;
        }

          for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];

            dist[u][v] = weight;
            dist[v][u] = weight;
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(dist[i][k]!=inf&&dist[k][j]!=inf){
                      dist[i][j]=  Math.min(dist[i][j],dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
         // Find city with minimum number of reachable neighbors
        int minCount = inf;
        int answer = -1;
        for(int i=0;i<n;i++){
            int count=0;
            for(int j=0;j<n;j++){
                if(i!=j && dist[i][j]<=distanceThreshold){
                    count++;
                }
            }
        
        // <= handles the tie:
            // if same count, choose larger city index
            if (count <= minCount) {
                minCount = count;
                answer = i;
            }
    }
    return answer;
    }
}