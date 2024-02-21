import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        // <참가자의 이름,참가 횟수>
        Map<String, Integer> passMap = new HashMap<>();
        for (String part : participant) {
            passMap.put(part, passMap.getOrDefault(part, 0) + 1);
        }

        // 완주한 선수들의 참가 횟수 감소
        for (String comp : completion) {
            passMap.replace(comp, passMap.get(comp) - 1);
        }

        // 남아있는 횟수가 0이 아닌 선수를 찾아서 반환
        for (Map.Entry<String, Integer> entry : passMap.entrySet()) {
            if (entry.getValue() != 0) {
                return answer = entry.getKey();
            }
        }

        return answer;
    }
}
