import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answerList = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int days = (int) Math.ceil((100.0 - progresses[i]) / speeds[i]);
            que.add(days);
        }
        
        while (!que.isEmpty()) {
            int current = que.poll();
            int count = 1;
            
            while (!que.isEmpty() && que.peek() <= current) {
                que.poll();
                count++;
            }
            
            answerList.add(count);
        }
        
        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answerList.size(); i++) {
            answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
