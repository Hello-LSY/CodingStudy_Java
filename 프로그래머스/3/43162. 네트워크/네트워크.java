import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i,n,computers,visited);
                answer++;
            }
        }
        
        return answer;
    }
    
    private void bfs(int start, int n, int[][] computers, boolean[] visited){
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        
        while(!queue.isEmpty()){
            int cur = queue.poll();
            visited[cur] = true;
            
            for(int i=0; i<n; i++){
                if(computers[i][cur]==1 && !visited[i]){
                    queue.offer(i);
                    visited[i]=true;
                }
            }
        }
        
    }
    
}