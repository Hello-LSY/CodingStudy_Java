import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();
        
        for (int i = 0; i < length; i++) {
            String rotated = rotateString(s, i);
            if (isBracket(rotated)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private String rotateString(String s, int x) {
        return s.substring(x) + s.substring(0, x);
    }
    
    private boolean isBracket(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((c == ')' && top != '(') || 
                    (c == ']' && top != '[') || 
                    (c == '}' && top != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
