import java.util.Arrays;

class Solution {
    public String[] solution(String myStr) {
        String[] str = myStr.split("[abc]");
        int length=0;
        for(String s : str){
            if(!s.isEmpty())length++;
        }
        
        String[]answer = new String[length];
        int index=0;
        for (String s : str) {
            if (!s.isEmpty()) {
                answer[index++] = s;
            }
        }
        
        if(answer.length==0)return new String[]{"EMPTY"};
        else return answer;
    }
}