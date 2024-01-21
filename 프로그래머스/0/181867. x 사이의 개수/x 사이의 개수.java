import java.util.*;

class Solution {
    public int[] solution(String myString) {
        List<Integer> answer = new ArrayList<>();
        int i = 0;

        for (char s : myString.toCharArray()) {
            if (s == 'x') {
                answer.add(i);
                i=0;
            } else i++;
        }
        answer.add(i);

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
