import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;

        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < ingredient.length; i++) {
            list.add(ingredient[i]);
            int idx = list.size();
            if (idx >= 4 &&
                    list.get(idx - 4) == 1 &&
                    list.get(idx - 3) == 2 &&
                    list.get(idx - 2) == 3 &&
                    list.get(idx - 1) == 1) {
                answer++;
                for (int j = 0; j < 4; j++) {
                    list.remove(list.size() - 1);
                }
            }
        }

        return answer;
    }
}
