class Solution {
    public String solution(String my_string, int n) {
        String answer = "";
        
        for(int i=0; i<my_string.length(); i++){
            char ch = my_string.charAt(i);
            answer+= String.valueOf(ch).repeat(n);
        }
        
        return answer;
    }
}