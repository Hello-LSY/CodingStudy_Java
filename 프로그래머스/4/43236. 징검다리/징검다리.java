import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        Arrays.sort(rocks);
        
        int left = 0;
        int right = distance;
        
        while(left<=right){
            int mid = (left+right)/2;
            
            if(cal(mid, distance, rocks, n)){
                left = mid+1;
                answer = mid;
            }else{
                right = mid - 1;
            }
            
        }
        
        return answer;
    }
    
    private boolean cal(int mid, int distance, int[] rocks, int n){
        int prev=0;
        int cnt=0;
        
        for(int rock : rocks){
            if(rock - prev < mid){
                cnt++;
            }else{
                prev = rock;
            }
        }
        
        if(distance - prev < mid){
            cnt++;
        }
        
        if(cnt<=n){
            return true;
        }else{
            return false;
        }
        
    }
    
}