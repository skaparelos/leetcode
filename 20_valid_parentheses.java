public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        if (len == 0) return true;
        Stack<Character> st = new Stack();
        for (char c : s.toCharArray()){
            if (c == '(' || c == '{' || c == '[')
                st.push(c);
            else if(st.isEmpty() || st.pop() != opposite(c)) {
                return false;
            }
        }
        
        return st.isEmpty();
    }
    
    public char opposite(char c){
        if (c == '}') return '{';
        else if (c == ']') return '[';
        else if (c == ')') return '(';
        else return ' ';
    }
}
