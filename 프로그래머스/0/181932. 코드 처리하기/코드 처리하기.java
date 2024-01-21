class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        
        for(int i=0; i<code.length(); i++){
            if(code.charAt(i)=='1'){
                mode=1-mode;
                continue;
            }
            
            if(mode==0 && i%2==0)answer+=code.charAt(i);
            else if(mode==1 && i%2==1)answer+=code.charAt(i);
        }
        
        if(answer.isEmpty())return "EMPTY";
        else return answer;
    }
}