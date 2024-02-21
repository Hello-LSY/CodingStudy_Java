import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>(); // 각 작업이 배포되기까지 남은 일수 저장
        ArrayList<Integer> list = new ArrayList<>(); // 각 배포마다 몇 개의 기능이 배포되었는지 저장

        // 각 작업이 배포되기까지 남은 일수
        for (int i = 0; i < progresses.length; i++) {
            int remainDays = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.offer(remainDays);
        }

        int cnt = 1; // 배포되는 기능의 개수
        int before = queue.poll(); // 이전 작업의 남은 일수

        while (!queue.isEmpty()) {
            int current = queue.poll(); // 현재 작업의 남은 일수

            if (before >= current) {
                // 같은 날에 배포되는 기능인경우
                cnt++;
            } else {
                // 현재 작업의 남은 일수 > 이전 작업
                list.add(cnt); // 이전까지의 cnt를 리스트에 추가
                cnt = 1; 
                before = current; // 현재 작업의 남은 일수로 업데이트
            }
        }
        list.add(cnt); // 마지막 배포에 대한 cnt를 리스트에 추가

        // 리스트를 배열로 변환하여 반환
        return list.stream().mapToInt(i -> i).toArray();
    }
}
