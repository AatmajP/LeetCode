class Solution {
    public String simplifyPath(String path) {
        String[] ar=path.split("/");
        Stack<String> stack=new Stack();
        for(int i=0;i<ar.length;i++){
            String st=ar[i];
            if(st.equals("..") && !stack.empty()){
                stack.pop();
            }else if(!st.equals("")&& !st.equals(".") && !st.equals("..")){
                stack.push(st);
            }
        }
        StringBuilder s=new StringBuilder();
        for(int i=0;i<stack.size();i++){
            String st=stack.get(i);
            s.append("/");
            s.append(st);
        }
        return s.length()==0? "/":s.toString();
    }
}