import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        
        Arrays.sort(times);        
        
        long left = 0;
        long right = (long)times[times.length-1] * n;
        
        while(left<=right){
            long mid = (left+right)/2;
            //심사 통과한 사람 수
            long calHumanCnt = 0;
            //심사관마다 중간시간을 기준으로 심사할 수 있는 사람 수 
            for(int time : times)
                calHumanCnt += mid/time;
            //범위줄이기
            if(calHumanCnt >= n){
                right = mid-1;
                answer = mid;
            }else{
                left = mid+1;
            }
        }
        
        return answer;
    }
    
}

        