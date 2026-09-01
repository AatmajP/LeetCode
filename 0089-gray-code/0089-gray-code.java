class Solution {
    public List<Integer> grayCode(int n) {
        int size=1<<n;
        int[] arr=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=i^(i>>1);
        }
        List<Integer> ans=new ArrayList<>();
        for(int i:arr){
            ans.add(i);
        }return ans;
    }
}