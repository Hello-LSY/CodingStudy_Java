import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer=0;
        PriorityQueue<Integer> scvPQ = new PriorityQueue<>();
        
        for(int i : scoville){
            scvPQ.add(i);
        }
        
        while(scvPQ.peek()<K && scvPQ.size()!=1){
            int fQ = scvPQ.poll();
            int sQ = scvPQ.poll();
            int scvilleScore = fQ + (sQ*2);
            scvPQ.offer(scvilleScore);   
            answer++;
        }
        
        return scvPQ.peek()>=K ? answer : -1;
    }
}
