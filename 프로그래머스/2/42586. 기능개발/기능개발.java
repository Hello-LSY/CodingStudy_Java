import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Queue<Integer> que = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<progresses.length; i++){
            // 소수점으로 남아도 하루 더 해야함
            int day = (int)Math.ceil((100.0-progresses[i])/speeds[i]);
            que.offer(day);
        }
        
        while(!que.isEmpty()){
            int work = que.poll();
            int cnt = 1;
            while(!que.isEmpty() && work>=que.peek()){
                que.poll();
                cnt++;
            }
            list.add(cnt);
        }
        int[] answer = new int[list.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = list.get(i);
        }
        
        
        return answer;
    }
}