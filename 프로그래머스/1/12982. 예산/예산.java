import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        
        Arrays.sort(d);
        
        for(int money : d){
            if(budget-money<0){
                continue;
            }else{
                budget-=money;
                answer++;
            }
        }
        
        return answer;
    }
}