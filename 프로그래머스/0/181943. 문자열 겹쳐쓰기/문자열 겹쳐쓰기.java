import java.lang.StringBuilder;

class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        
        StringBuilder answer = new StringBuilder(my_string);
        int o_len = overwrite_string.length();
        
        return answer.replace(s, s+o_len, overwrite_string).toString();
    }
}