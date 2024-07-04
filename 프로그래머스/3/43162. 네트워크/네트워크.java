import java.util.*;
class Solution {
    private static boolean visited[];
    public int solution(int n, int[][] computers) {
        int answer = 0;
        
        visited = new boolean[n];
        for(int i=0; i<n; i++){
            //새로운 곳 = 새로운 네트워크 발견
            if(!visited[i]){
                bfs(i, n, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    
    private void bfs(int start, int n, int[][] computers){
        Queue<Integer> que = new LinkedList<>();
        que.add(start);
        visited[start] = true;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            
            for(int i=0; i<n; i++){
                if(!visited[i] && computers[cur][i]==1){
                    que.add(i);
                    visited[i] = true;
                }
            }
        }
        
    }
}