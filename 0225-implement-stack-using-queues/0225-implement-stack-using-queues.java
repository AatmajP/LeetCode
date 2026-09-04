class MyStack {
          Queue<Integer> q = new LinkedList<>();

    public MyStack() {
        
    }
    
    public void push(int x) {
        q.offer(x);

        //now we will rotate the queue to do stack operation
        int n=q.size();
        while(n>1){
            q.offer(q.poll());
            n--;
        }
        
    }
    
    public int pop() {
       return q.poll();
    }
    
    public int top() {
        return q.peek();

        
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */