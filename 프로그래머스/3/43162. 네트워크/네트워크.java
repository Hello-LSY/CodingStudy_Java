import java.util.*;
class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(computers, i);
                answer++;
            }
        }
        
        
        return answer;
    }
    
    private void bfs(int[][] computers, int start){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int i=0; i<computers.length; i++){
                if(!visited[i] && computers[cur][i]==1){
                    que.offer(i);
                    visited[i]=true;
                }
            }
        }
    }
    
}