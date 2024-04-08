import java.util.*;

class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> list = new ArrayList<>();
        int idx=0;
        long f = 1;
        for(int i=1; i<=n; i++){
            list.add(i);
            f *= i;
        }
        
        k--;
        while(n>0){
            f /= n;
            int value = (int)(k/f);
            answer[idx++] = list.get(value);
            list.remove(value);
            
            k%= f;
            n--;
            
        }
        
        return answer;
    }
}