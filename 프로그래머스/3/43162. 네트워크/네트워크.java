import java.util.*;

class Solution {
    public static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];   
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, n, visited, computers);
                answer++;
            }
        }            
        return answer;
    }    
    
    public static void bfs(int start, int n, boolean[] visited, int[][] computers){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true; 
        
        while(!que.isEmpty()){
            int cur = que.poll();   
            
            for(int i=0; i<n; i++){
                if(computers[cur][i] == 1 && !visited[i]){
                    que.offer(i);
                    visited[i]=true;
                }
            }
        }       
    }
}