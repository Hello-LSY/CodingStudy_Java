import java.util.*;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        // 시간 저장
        Stack<Integer> stk = new Stack<>();
        // n번 완탐
        for(int i=0; i<prices.length; i++){
            
            // 스택 최상단에 있는 값(i 시점의 가격) > 현재 주식가격 이면 시간계산
            while(!stk.isEmpty() && prices[i]<prices[stk.peek()]){
                answer[stk.peek()] = i - stk.pop();
            }
            stk.push(i);
        }
        
        // 남은 주식들 = 변동없으므로 prices크기 -1 에서 시점을 빼서 갱신
        while(!stk.isEmpty()){
            answer[stk.peek()] = prices.length - stk.pop() - 1;
        }
        
        return answer;
    }
}