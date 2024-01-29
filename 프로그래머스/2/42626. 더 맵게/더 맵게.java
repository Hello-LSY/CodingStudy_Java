import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i : scoville) {
            pq.add(i);
        }

        int answer = 0;

        while (true) {
            if (pq.peek() >= K) break;
            if (pq.size() < 2) return -1;

            int f_s = pq.poll();
            int s_s = pq.poll();
            int mixed = f_s + (s_s * 2);
            pq.add(mixed);
            answer++;
        }

        return answer;
    }
}
