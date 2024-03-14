import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        //트럭을 저장하는 스택 
        Stack<Integer> truckStack = new Stack<>();
        //다리 위의 트럭 상태
        Map<Integer, Integer> bridgeMap = new HashMap<>();

        // 트럭을 스택에 넣기
        for (int i = truck_weights.length - 1; i >= 0; i--)
            truckStack.push(truck_weights[i]);
        
        // 경과시간
        int time = 0;
        //현재 다리 위에 있는 트럭의 무게
        int sum = 0;
        // 모든 트럭이 다리를 건널 때까지 
        while (true) {
            time++; //경과 시간 증가

            // 다리를 건너고 있는 트럭 중, 도착한 트럭은 제거
            if (bridgeMap.containsKey(time))
                bridgeMap.remove(time);

            sum = bridgeMap.values().stream().mapToInt(Number::intValue).sum();

            //다리에 트럭을 추가해도 무게 제한을 초과하지 않으면 트럭 추가
            if (!truckStack.isEmpty())
                if (sum + truckStack.peek() <= weight)
                    bridgeMap.put(time + bridge_length, truckStack.pop());

            // 다리와 대기 중인 트럭이 모두 비어있으면 종료
            if (bridgeMap.isEmpty() && truckStack.isEmpty())
                break;
        }
        return time; 
    }
}
