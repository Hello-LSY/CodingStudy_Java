import java.util.*;

class Solution {
    
    PriorityQueue<String> pQ;
    boolean[] visited;
    
    public String[] solution(String[][] tickets) {
        
        String[] answer = {};
        pQ = new PriorityQueue<>();
        visited = new boolean[tickets.length];
        dfs("ICN", "ICN", tickets, 0);
        answer = pQ.poll().split(" ");
        
        return answer;
    }
    
    public void dfs(String start, String route, String[][] tickets, int cnt){

        if(tickets.length == cnt){
            pQ.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++){
            if(!visited[i] && tickets[i][0].equals(start) ){
                visited[i]=true;
                dfs(tickets[i][1], route + " " + tickets[i][1], tickets, cnt+1);
                visited[i]=false;
            }
            
        }
        
    }
}