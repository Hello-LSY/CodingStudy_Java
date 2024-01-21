class Solution {
    public int solution(String binomial) {
        int answer = 0;
        
        String[] bino = binomial.split(" ");
        answer += Integer.parseInt(bino[0]);
        
        if(bino[1].equals("+"))answer+=Integer.parseInt(bino[2]);
        else if(bino[1].equals("-"))answer-=Integer.parseInt(bino[2]);
        else if(bino[1].equals("*"))answer*=Integer.parseInt(bino[2]);
        
        
        return answer;
    }
}