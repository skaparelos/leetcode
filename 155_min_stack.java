public class MinStack {

    ArrayList <Tuple> s;
    
    /** initialize your data structure here. */
    public MinStack() {
       s = new ArrayList<>();
    }
    
    public void push(int x) {
        if(s.isEmpty()){
            s.add(new Tuple(x, x));
        }else{
            s.add(new Tuple(x, Math.min(x, getMin())));
        }
    }
    
    public void pop() {
        s.remove(s.size() - 1);
    }
    
    public int top() {
        return s.get(s.size() - 1).item;
    }
    
    public int getMin() {
        return s.get(s.size() - 1).min;
    }
    
    private class Tuple{
        int item;
        int min;
        
        private Tuple(int i, int m){
            item = i;
            min = m;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
