import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String, Integer> passMap = new HashMap<>();
        for(String part : participant){
            passMap.put(part, passMap.getOrDefault(part, 0)+1);
        }
        
        for(String comp : completion){
            passMap.replace(comp, passMap.get(comp)-1);
        }

        for(Map.Entry<String, Integer>entry : passMap.entrySet()){
            if(entry.getValue()!=0)return answer = entry.getKey();
        }
        
        return answer;
    }
}
