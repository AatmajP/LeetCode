class Solution {
    public boolean isPowerOfFour(int n) {
        if(n<=0) return false;
        if((n&(n-1))!=0) return false;

        int mask= 0x55555555;
        return (n&mask)!=0;

    }
}