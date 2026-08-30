class Solution {
    public int[] singleNumber(int[] nums) {
        int xor=0;
        for(int i:nums){
            xor^=i;
        }
        int bits=xor&(-xor); // this line help us to find the bit where we have to seperate.
        int a=0;
        int b=0;
        for(int i:nums){
            if((i&bits)==0){
                a=a^i;
            }else{
                b=b^i;
            }
        }return new int[]{a, b};

    }
}