import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] talkable = {"aya", "ye", "woo", "ma"};
        
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].contains("ayaaya") 
               || babbling[i].contains("yeye")
               || babbling[i].contains("woowoo")
               || babbling[i].contains("mama")) continue;
            for(String talk : talkable)
                babbling[i] = babbling[i].replace(talk, " ");
            if(babbling[i].trim().isEmpty()) answer++;
        }
        
        return answer;
    }
}