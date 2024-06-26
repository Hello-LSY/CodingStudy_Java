import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliverRemain = 0;
        int pickupRemain = 0;

        // 마지막 집부터 시작
        for (int i = n - 1; i >= 0; i--) {
            deliverRemain += deliveries[i];
            pickupRemain += pickups[i];

            while (deliverRemain > 0 || pickupRemain > 0) {
                answer += (i + 1) * 2; 
                deliverRemain -= cap;
                pickupRemain -= cap;
            }
        }

        return answer;
    }
}
