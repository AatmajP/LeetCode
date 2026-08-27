class Solution {
    public int maxSubArray(int[] nums) {
        int sum=nums[0];
        int pos=nums[0];
        for(int i=1;i<nums.length;i++){
            pos=Math.max(nums[i],nums[i]+pos);
            sum=Math.max(pos,sum);
        }
        return sum;
        
    }
}