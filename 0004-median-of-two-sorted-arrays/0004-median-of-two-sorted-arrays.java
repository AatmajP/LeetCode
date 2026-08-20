class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int a1=nums1.length;
        int b1=nums2.length;
        int c1=a1+b1;
        int[] c=new int[c1];
        for(int i=0;i<a1;i++){
            c[i]=nums1[i];
        }
        for(int i=0;i<b1;i++){
            c[a1 + i]=nums2[i];
        }
        Arrays.sort(c);
        if(c.length%2==0){
            int middle=(c.length/2)-1;
            int middle1=c.length/2;
            double res=(c[middle]+c[middle1])/2.0;
            return res;
        }
            int middle1=c.length/2;
            int res1=c[middle1];
            return res1;
    }
}