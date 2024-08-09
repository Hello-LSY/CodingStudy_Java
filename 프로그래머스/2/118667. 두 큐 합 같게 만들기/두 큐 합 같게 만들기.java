import java.util.*;
class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int n = queue1.length;
        long total1 = 0;
        long total2 = 0;
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        for(int i=0; i<n; i++){
            que1.offer(queue1[i]);
            que2.offer(queue2[i]);
            total1+=queue1[i];
            total2+=queue2[i];
        }
        
        long total = total1 + total2;
        long target = total/2;
        int limit = n*2 + 1;
        
        while(total1!=target && answer<=limit){
            
            if(total1>target){
                int value = que1.poll();
                total1-=value;
                total2+=value;
                que2.offer(value);
            }else{
                int value = que2.poll();
                total2-=value;
                total1+=value;
                que1.offer(value);
            }
            answer++;
        }
        
        return total1== target ? answer : -1;
    }
}