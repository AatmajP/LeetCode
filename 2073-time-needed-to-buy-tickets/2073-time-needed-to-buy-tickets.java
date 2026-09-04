class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < tickets.length; i++){
            q.offer(i);
        }

        int sec = 0;

        while(tickets[k] > 0){

            int per = q.poll();

            tickets[per]--;
            sec++;

            if(tickets[per] > 0){
                q.offer(per);
            }
        }

        return sec;
    }
}