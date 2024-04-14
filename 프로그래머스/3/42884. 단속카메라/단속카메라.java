import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        //[[-5,-3], [-14,-5], [-18,-13], [-20,-15]]
        Arrays.sort(routes, (o1,o2) -> o1[1] - o2[1]);
        int before = Integer.MIN_VALUE;
        
        for(int[] route : routes){
            if(before < route[0]){
                answer++;
                before = route[1];
            }
            
        }
        
        return answer;
    }
}