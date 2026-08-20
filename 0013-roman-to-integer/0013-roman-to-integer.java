class Solution {
    public int romanToInt(String s) {
        int values[]={1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String  roman[]={"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i=0;
        int result=0;
        while(s.length()>0){
            if(s.startsWith(roman[i])){
                result+=values[i];
                s=s.substring(roman[i].length());
            }else{
                i++;
            }
        }
        return result;
    }
}
    
