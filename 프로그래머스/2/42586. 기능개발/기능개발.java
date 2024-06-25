import java.util.*;

class Solution {
    
    public class Progress {
        int progress;
        int speed;
        
        public Progress(int progress, int speed){
            this.progress = progress;
            this.speed = speed;
        }

        public int getRemainingDays() {
            return (int)Math.ceil((100.0 - progress) / speed);
        }
    }
    
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Progress> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            queue.add(new Progress(progresses[i], speeds[i]));
        }

        List<Integer> resultList = new ArrayList<>();

        while (!queue.isEmpty()) {
            // 첫 번째 기능의 남은 일수 계산
            int days = queue.peek().getRemainingDays();

            // 해당 일수 동안 모든 기능 업데이트
            for (Progress progress : queue) {
                progress.progress += progress.speed * days;
            }

            int count = 0;
            while (!queue.isEmpty() && queue.peek().progress >= 100) {
                queue.poll();
                count++;
            }
            resultList.add(count);
        }
        
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i);
        }
        
        return answer;
    }
}
