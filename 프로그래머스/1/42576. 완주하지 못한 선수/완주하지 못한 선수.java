// import java.util.*;

// class Solution {
//     public String solution(String[] participant, String[] completion) {
//         String answer = "";

//         // <참가자의 이름,참가 횟수>
//         Map<String, Integer> passMap = new HashMap<>();
//         for (String part : participant) {
//             passMap.put(part, passMap.getOrDefault(part, 0) + 1);
//         }

//         // 완주한 선수들의 참가 횟수 감소
//         for (String comp : completion) {
//             passMap.replace(comp, passMap.get(comp) - 1);
//         }

//         // 남아있는 횟수가 0이 아닌 선수를 찾아서 반환
//         for (Map.Entry<String, Integer> entry : passMap.entrySet()) {
//             if (entry.getValue() != 0) {
//                 return answer = entry.getKey();
//             }
//         }

//         return answer;
//     }
// }

import java.util.HashSet;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashSet<String> hashSet = new HashSet<>();
        
        for(int i=0; i<participant.length; i++){
            int cnt=0;
            for(int j=0; j<completion.length; j++){
                if(participant[i].equals(completion[j])){
                    if(!hashSet.add(participant[i]))answer=participant[i];
                    cnt++;
                }
            }
            if(cnt==0)answer=participant[i];
        }
        
        
        return answer;
    }
}
