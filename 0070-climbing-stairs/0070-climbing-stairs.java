/*import java.util.*;
class Solution {
    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        else{
            return climbStairs(n-1)+climbStairs(n-2);
        }
    }
    public static void main(String[] args){
            Scanner s=new Scanner(System.in);
            int a=s.nextInt();
            System.out.println(climbStairs(a));
    }
}*/

import java.util.*;

class Solution {
    public static int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        int first = 1;  // ways to climb 1 stair
        int second = 2; // ways to climb 2 stairs

        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second; // final answer
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        System.out.println(climbStairs(a));
    }
}



