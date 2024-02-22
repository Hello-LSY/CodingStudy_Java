import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        // 힙 구현
        PriorityQueue<Integer> scvPQ = new PriorityQueue<>();
        
        for (int i : scoville) {
            scvPQ.add(i);
        }
        
        // 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복
        while (scvPQ.peek() < K && scvPQ.size() != 1) {
    
            int fQ = scvPQ.poll();
            int sQ = scvPQ.poll();
            int scvilleScore = fQ + (sQ * 2);
            // 섞은 음식의 스코빌 지수를 우선순위 큐에 추가
            scvPQ.offer(scvilleScore);   
            // 섞은 횟수 증가
            answer++;
        }
        
        
        return scvPQ.peek() >= K ? answer : -1;
    }
}
