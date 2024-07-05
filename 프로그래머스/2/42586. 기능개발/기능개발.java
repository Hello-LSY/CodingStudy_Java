import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> result = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        
        for(int i=0; i<progresses.length; i++){
            // 걸리는 일수를 큐에 넣기
            int day = (int)Math.ceil((100.0 - progresses[i])/speeds[i]);
            que.offer(day);
        }
        
        int progress = que.poll();
        // 첫 작업은 이미 함
        int cnt = 1; 
        
        while(!que.isEmpty()){
            if(progress >= que.peek()){
                cnt++;
                que.poll();
            } else {
                result.add(cnt);
                cnt = 1;  
                progress = que.poll();
            }
        }
        // 마지막 작업
        result.add(cnt);
        
        int[] answer = new int[result.size()];
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }
        
        return answer;
    }
}
