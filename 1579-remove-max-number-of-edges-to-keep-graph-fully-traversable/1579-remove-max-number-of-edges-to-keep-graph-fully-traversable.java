class Solution {
    int[] parentA;
    int[] parentB;
    public int find(int[] parent,int x){
        if(parent[x]==x) return x;
        return parent[x]=find(parent,parent[x]);
    }
    boolean union(int[] parent,int a,int b){
        int rootA=find(parent,a);
        int rootB=find(parent,b);
        if(rootA==rootB){
            return false;

        }
        parent[rootB]=rootA;
        return true;
    }

    public int maxNumEdgesToRemove(int n, int[][] edges) {
         parentA=new int[n+1];
         parentB=new int[n+1];
         for(int i=1;i<n;i++){
            parentA[i]=i;
            parentB[i]=i;
    }
         int used=0;
         for(int[] ed:edges){
            if(ed[0]==3){
                int u=ed[1];
                int v=ed[2];
                boolean alice=union(parentA,u,v);
                boolean bob=union(parentB,u,v);
                if(alice||bob){
                    used++;
                }
            }
         }
         // 2. Process Type 1 - Alice
        for (int[] edge : edges) {

            if (edge[0] == 1) {

                int u = edge[1];
                int v = edge[2];

                if (union(parentA, u, v)) {
                    used++;
                }
            }
        }

        // 3. Process Type 2 - Bob
        for (int[] edge : edges) {

            if (edge[0] == 2) {

                int u = edge[1];
                int v = edge[2];

                if (union(parentB, u, v)) {
                    used++;
                }
            }
        } // Check Alice and Bob are fully connected
        int aliceRoot = find(parentA, 1);
        int bobRoot = find(parentB, 1);

        for (int i = 2; i <= n; i++) {

            if (find(parentA, i) != aliceRoot ||
                find(parentB, i) != bobRoot) {

                return -1;
            }
        }

        return edges.length - used;
    }
}