import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        Stack<Integer> stk = new Stack<>();

        for (int i = 0; i < ingredient.length; i++) {
            stk.push(ingredient[i]);
            int idx = stk.size();
            if (idx >= 4 &&
                    stk.get(idx - 4) == 1 &&
                    stk.get(idx - 3) == 2 &&
                    stk.get(idx - 2) == 3 &&
                    stk.get(idx - 1) == 1) {
                answer++;
                for (int j = 0; j < 4; j++) {
                    stk.pop();
                }
            }
        }

        return answer;
    }
}
