import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        HashMap<String, Integer> participantMap = new HashMap<>();

        //map에 참가자 담기(중복이면 +1)
        for (String p : participant) {
            participantMap.put(p, participantMap.getOrDefault(p, 0) + 1);
        }

        //map의 value에 완주자만큼 빼기
        for (String c : completion) {
            participantMap.put(c, participantMap.get(c) - 1);
        }

        //key가 하나이상 = 완주못한사람 or 중복된 사람
        for (String key : participantMap.keySet()) {
            if (participantMap.get(key) > 0) {
                answer = key;
                break;
            }
        }

        return answer;
    }
}
