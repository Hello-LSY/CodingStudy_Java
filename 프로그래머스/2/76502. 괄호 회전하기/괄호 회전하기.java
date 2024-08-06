import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = 0;
        
        for(int i=0; i<s.length(); i++){
            if(isBracket(rotate(s, i))){
                answer++;
            }
        }
        
        
        return answer;
    }
    
    //선형 완탐 로직
    private boolean isBracket(String s){
        Stack<Character> stk = new Stack<>();
        
        for(int i=0; i<s.length(); i++){
            char cur = s.charAt(i);
            if(cur=='{' || cur=='[' || cur=='('){
                stk.push(cur);
            } else{
                if(stk.isEmpty()) return false;
                char top = stk.pop();
                if((cur=='}' && top != '{') || 
                   (cur==']' && top!='[') || 
                   (cur==')' && top!='(')){
                    return false;
                }
            }
        }
        
        return stk.isEmpty();
    }
    
    
    //회전하는 로직
    private String rotate(String s, int step){
        return s.substring(step) + s.substring(0, step);
    }
    
    
}