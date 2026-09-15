class Solution {
    int[] par;
    public int find(int x){
        if(par[x]==x){
            return x;
        }
        return par[x]=find(par[x]);
    }
    void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA!=rootB){
            par[rootB]=rootA;
        }
}
    public boolean equationsPossible(String[] equations) {
        //converting the string in numbers
        par=new int[26];
        for(int i=0;i<26;i++){
            par[i]=i;
        }
        for(String st:equations){

            //a==b where if u see he position wise a=0 , = is at 1,= is at 2
            //b=3;
            if(st.charAt(1)== '='){
                int a=st.charAt(0)-'a'; // 0 is position 
                int b=st.charAt(3)-'a'; // 3 is alos same
                union(a,b);
            }
            

        }
        for(String st:equations){
            if(st.charAt(1)=='!'){
               int a = st.charAt(0) - 'a';
                int b = st.charAt(3) - 'a';
                if(find(a)==find(b)){
                    return false;
                }
            }
        }
        return true;



        
    }
}