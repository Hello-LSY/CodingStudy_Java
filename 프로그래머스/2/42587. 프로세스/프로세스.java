import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> process = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<priorities.length; i++){
            //[인덱스, 우선순위]
            process.add(new int[]{i, priorities[i]});
            pq.add(priorities[i]);
        }
        int cnt=1;
        while(!process.isEmpty()){
            int[] cur = process.poll();
            if(cur[1]<pq.peek()){
                process.add(cur);
            }else{
                if(cur[0]==location)break;
                pq.poll();
                cnt++;
            }
            
        }
        
        
        return cnt;
    }
}