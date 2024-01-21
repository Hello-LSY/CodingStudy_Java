class Solution {
    public int solution(int hp) {
        int answer = 0;
        int g_ant = 5, s_ant = 3, w_ant = 1;
        
        while(hp!=0){
            if(hp-g_ant>=0)hp-=g_ant;
            else if(hp-s_ant>=0)hp-=s_ant;
            else hp-=w_ant;
            answer++;
        }
        
        return answer;
    }
}