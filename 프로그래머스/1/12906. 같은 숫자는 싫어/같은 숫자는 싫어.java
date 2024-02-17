import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> stk = new Stack<>();
        
        stk.push(arr[0]);
        for(int i : arr){
            if(stk.peek()!=i)stk.push(i);
        }
        
        int[] answer = new int[stk.size()];
        int cnt=stk.size()-1;
        
        while(!stk.isEmpty()){
            answer[cnt--] = stk.pop();
        }

        return answer;
    }
}