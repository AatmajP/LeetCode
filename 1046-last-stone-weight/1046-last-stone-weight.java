class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            pq.offer(i);
        }
        while(pq.size()>1){
            int f=pq.poll();
            int s=pq.poll();
            int sum=f-s;
            if(f!=s){
                pq.offer(sum);
            }
        }
        return pq.isEmpty()?0:pq.peek();
    }
}