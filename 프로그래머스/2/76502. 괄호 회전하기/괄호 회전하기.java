import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            if(isBracket(rotate(s, i))) answer++; 
        }
        
        return answer;
    }
    
    private boolean isBracket(String s){
        Stack<Character> stk = new Stack<>();
        char[] cArr = s.toCharArray();
        for(char c : cArr){
            if(c=='{' || c=='[' || c=='('){
                stk.push(c);
            }else{
                if(stk.isEmpty())return false;
                if((c=='}' && stk.peek()=='{') || 
                   (c==']' && stk.peek()=='[') ||
                   (c==')' && stk.peek()=='(')) stk.pop();
                else return false;
            }
        }
        return stk.isEmpty();
    }
    
    
    private String rotate(String s, int idx){
        return s.substring(idx) + s.substring(0, idx);
    }
}