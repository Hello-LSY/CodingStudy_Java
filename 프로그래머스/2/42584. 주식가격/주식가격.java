import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stock = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stock.isEmpty() && prices[i] < prices[stock.peek()]) {
                int index = stock.pop();
                answer[index] = i - index;
            }
            stock.push(i);
        }

        while (!stock.isEmpty()) {
            int index = stock.pop();
            answer[index] = prices.length - 1 - index;
        }

        return answer;
    }
}
