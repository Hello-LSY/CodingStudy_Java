import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        // 두 개의 우선순위 큐를 사용하여 최솟값과 최댓값을 추적
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        HashMap<Integer, Integer> countMap = new HashMap<>();
        
        for(String operation : operations){
            String[] command = operation.split(" ");
            String alpha = command[0];
            int digit = Integer.parseInt(command[1]);

            if (alpha.equals("I")) {
                // 숫자 삽입
                minHeap.add(digit);
                maxHeap.add(digit);
                countMap.put(digit, countMap.getOrDefault(digit, 0) + 1);
            } else if (alpha.equals("D")) {
                if (digit == 1) {
                    // 최댓값 삭제
                    removeElement(maxHeap, countMap);
                } else {
                    // 최솟값 삭제
                    removeElement(minHeap, countMap);
                }
            }
        }

        // 결과 계산
        if (countMap.isEmpty()) {
            return new int[]{0, 0};
        }else{
            int max = removeElement(maxHeap, countMap);
            int min = removeElement(minHeap, countMap);

            return new int[]{max, min};
        }

    }

    private int removeElement(PriorityQueue<Integer> heap, HashMap<Integer, Integer> countMap) {
        while (!heap.isEmpty()) {
            int element = heap.poll();
            int count = countMap.getOrDefault(element, 0);
            if (count > 0) {
                if (count == 1) {
                    countMap.remove(element);
                } else {
                    countMap.put(element, count - 1);
                }
                return element;
            }
        }
        return 0;
    }
}
