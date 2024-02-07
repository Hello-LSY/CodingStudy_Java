import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answerBuilder = new StringBuilder();
        
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        
        for (char c : X.toCharArray()) {
            int i = Character.getNumericValue(c);
            xMap.put(i, xMap.getOrDefault(i, 0) + 1);
        }
        
        for (char c : Y.toCharArray()) {
            int i = Character.getNumericValue(c);
            yMap.put(i, yMap.getOrDefault(i, 0) + 1);
        }
        
        for (int i = 9; i >= 0; i--) {
            if (xMap.containsKey(i) && yMap.containsKey(i)) {
                int cnt = Math.min(xMap.get(i), yMap.get(i));
                while (cnt-- > 0) {
                    answerBuilder.append(i);
                }
            }
        }
        
        String answer = answerBuilder.toString();
        if (answer.isEmpty()) return "-1";
        else if (answer.charAt(0) == '0') return "0";
        else return answer;
    }
}
