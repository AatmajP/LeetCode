class Solution {
    public double myPow(double x, int n) {
       double res=1;
       double base=x;
        long exp=n;

         //this is for handling negative part
        boolean neg=exp<0;
        if(neg){
            exp=-exp;
        }
        //this is for positive
        while(exp!=0){
            if(exp%2!=0){
                res=res*base;
            }
            base=base*base;
            exp=exp/2;
        }
        if(neg){
            res=1/res;
        }return res;

    }
}