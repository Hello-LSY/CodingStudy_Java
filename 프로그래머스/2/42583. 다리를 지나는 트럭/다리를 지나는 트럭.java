import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0; 
        Queue<Integer> bridge = new LinkedList<>();
        Queue<Integer> truck = new LinkedList<>();
        int nowWeight = 0;

        for (int i : truck_weights) {
            truck.add(i);
        }

        while (!truck.isEmpty()) {
            answer++;

            if (bridge.size() == bridge_length) { 
                nowWeight -= bridge.poll();
            }

            if (nowWeight + truck.peek() <= weight) {
                int truckWeight = truck.poll();
                nowWeight += truckWeight;
                bridge.add(truckWeight);
            } else {
                bridge.add(0);
            }
        }

        answer += bridge_length;
        return answer;
    }
}
