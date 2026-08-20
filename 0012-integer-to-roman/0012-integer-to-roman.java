import java.util.*;
class Solution {
    public String intToRoman(int num) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String  roman[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder r=new StringBuilder();
        for(int i=0;i<values.length;i++){
            while(num>=values[i]){
                r.append(roman[i]);
                num-=values[i];
            }
        }return r.toString();
    }
}