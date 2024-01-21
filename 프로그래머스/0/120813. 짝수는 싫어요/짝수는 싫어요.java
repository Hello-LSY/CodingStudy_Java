import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        if(n%2==0)n--;
        int[] answer = new int[n/2+1];
        int i=0;
        
        while(n!=-1){
            answer[i] = n;
            n-=2;
            i++;
        }
        Arrays.sort(answer);
        
        return answer;
    }
}