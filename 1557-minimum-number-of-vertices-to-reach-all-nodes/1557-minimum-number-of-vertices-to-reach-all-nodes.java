class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] inde=new int[n];
        for(List<Integer> ed:edges){
            int v=ed.get(1);
            inde[v]++;
        }
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(inde[i]==0){
                ans.add(i);
            }
        }
        return ans;
    }
}