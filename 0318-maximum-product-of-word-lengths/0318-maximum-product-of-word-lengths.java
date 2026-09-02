class Solution {
    public int maxProduct(String[] words) {
        int[] mask=new int[words.length];
        //this loop is for getting all words from array
        for(int i=0;i<words.length;i++){
            int currentmask=0;
            //this loop is for extracting single words from perticular string
            for(int j=0;j<words[i].length();j++){
                // tells the exact position of ecah words
                int position=words[i].charAt(j)-'a';
                currentmask=currentmask|(1<<position);
            }
         mask[i] = currentmask;}
        int max=0;
        //thses loops are use to compare each strings
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if((mask[i]&mask[j])==0){
                   int mul=words[i].length() * words[j].length();

                    max = Math.max(max, mul);
                }
            }
        }return max;
    }
}