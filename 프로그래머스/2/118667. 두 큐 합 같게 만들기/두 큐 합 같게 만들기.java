import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> que1 = new LinkedList<>();
        Queue<Integer> que2 = new LinkedList<>();
        
        long sum1 = 0, sum2 = 0; 
        for (int i = 0; i < queue1.length; i++) {
            que1.add(queue1[i]);
            sum1 += queue1[i];
            que2.add(queue2[i]);
            sum2 += queue2[i];
        }

        long totalSum = sum1 + sum2;
        // 총합이 홀수면 반으로 나눌 수 없으므로 -1 반환
        if (totalSum % 2 != 0) return -1;
        
        long target = totalSum / 2;
        int answer = 0;
        int limit = queue1.length * 2 + 1;
        
        // 투 포인터 방식으로 큐를 다룸
        while (sum1 != target && answer <= limit) {
            // 1 -> 2 
            if (sum1 > target) {
                int value = que1.poll();
                sum1 -= value;
                que2.add(value);
                sum2 += value;
            // 2 -> 1
            } else {
                int value = que2.poll();
                sum2 -= value;
                que1.add(value);
                sum1 += value;
            }
            answer++;
        }
        
        // 다 해도 합이 맞지 않으면 -1 반환
        return sum1 == target ? answer : -1;
    }
}
