class Solution {
    public int solution(int order) {
        int answer = 0;
        
        String num = Integer.toString(order);
        for(char s : num.toCharArray()){
            if(s=='3' || s=='6' || s=='9')answer++;
        }
        
        return answer;
    }
}