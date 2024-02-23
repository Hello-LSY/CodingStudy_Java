import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        int[] answer = {0,0};
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for(String operation : operations){
            String[] command = operation.split(" ");
            String alpha = command[0];
            int digit = Integer.parseInt(command[1]);
            if(alpha.equals("I")){
                minHeap.add(digit);
                maxHeap.add(digit);
            }else if(alpha.equals("D")){
                if(digit==1){
                    minHeap.remove(maxHeap.poll());
                }else
                    maxHeap.remove(minHeap.poll());
            }
        }
       
        return maxHeap.isEmpty() ? answer : new int[]{maxHeap.poll(), minHeap.poll()};
    }
}