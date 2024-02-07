import java.util.*;

class Solution {
    public int solution(int[] order) {
        Queue<Integer> containerBelt = new LinkedList<>();
        Stack<Integer> assistBelt = new Stack<>();

        for (int i = 1; i <= order.length; i++) {
            containerBelt.add(i);
        }

        int cnt = 0;
        while (cnt < order.length) {
            if (!containerBelt.isEmpty() && containerBelt.peek() == order[cnt]) {
                containerBelt.poll(); 
                cnt++; 
            } else if (!assistBelt.isEmpty() && assistBelt.peek() == order[cnt]) {
                assistBelt.pop(); 
                cnt++; 
            } else if (!containerBelt.isEmpty()) {
                assistBelt.push(containerBelt.poll()); 
            } else {
                break;
            }
        }

        return cnt;
    }
}
