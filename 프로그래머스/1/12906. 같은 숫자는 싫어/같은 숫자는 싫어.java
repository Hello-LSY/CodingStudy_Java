import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer>stk = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(!stk.empty() && stk.peek()==arr[i])continue;
            else {
                stk.push(arr[i]);
            }
        }
        
        
        int[] answer = new int[stk.size()];
        for (int i = answer.length - 1; i >= 0; i--) {
            answer[i] = stk.pop();
        }


        return answer;
    }
}