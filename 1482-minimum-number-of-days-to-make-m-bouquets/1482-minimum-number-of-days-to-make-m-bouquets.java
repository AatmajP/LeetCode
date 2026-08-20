class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long) m*k>bloomDay.length){
            return -1;
        }
        int left=Integer.MAX_VALUE;
        int right=Integer.MIN_VALUE;
         for (int day : bloomDay) {
            left = Math.min(left, day);
            right = Math.max(right, day);
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            int boq=0;
            int consecutive=0;
            for(int i:bloomDay){
                if(i<=mid){
                    consecutive++;
                    if(consecutive==k){
                        boq++;
                        consecutive=0;
                    }
                }else{
                    consecutive=0;
                }
            }
            if(boq>=m){
                right=mid-1;
            }else{
                left=mid+1;
            }
        }return left;
    }
}