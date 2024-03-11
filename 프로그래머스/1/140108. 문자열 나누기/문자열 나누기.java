class Solution {
    public int solution(String s) {
        int answer = 0;
        
        int pointer = 0;
        int correctCnt = 0;
        int nonCorrectCnt = 0;
        char c = s.charAt(pointer);
        while(pointer < s.length()){
            
            if(c == s.charAt(pointer)) correctCnt++;
            else nonCorrectCnt++;
            
            if(correctCnt == nonCorrectCnt){
                correctCnt = 0;
                nonCorrectCnt = 0;
                answer++;
                if(++pointer < s.length()) c = s.charAt(pointer);
            }else pointer++;
        }
        
        if(correctCnt != 0 || nonCorrectCnt != 0) answer++;
        
        return answer;
    }
}
