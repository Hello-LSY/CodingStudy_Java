import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        //첫번째 값(요청 시점) 기준으로 오름차순 정렬
		Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
        
        //<[요청시간,처리시간]>힙은 두번째 값(처리 시간)을 기준으로 오름차순 정렬; 이유는 요청시점이 정렬된 배열기준으로 프로세스 처리가 끝난 다음은 처리시간이 작은 값부터 처리되는게 효율적.
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        int time = jobs[0][0];
        int idx = 0;
        
        
        while(idx<jobs.length || !pq.isEmpty()){
            //프로세스가 현재시간에 도달하면 담기
            while(idx<jobs.length && jobs[idx][0]<=time){
                pq.add(jobs[idx++]);
            }
            //만약 비어있으면 다음 처리시간으로 갱신 
            if(pq.isEmpty()){
                //이렇게하면 증감연산자보다 효율적임 0..1..2 보단 0..3..8 처럼
                time = jobs[idx][0];
                pq.add(jobs[idx++]);
            }
            
            int[] w_time = pq.poll();
            //처리시간 갱신
            time+= w_time[1];
            //총 요청시간 갱신
            answer+= time-w_time[0];
        }
        
        return answer/jobs.length;
    }
}