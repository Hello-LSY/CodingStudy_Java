import java.util.*;

class Solution {
    static boolean[] visited;
    public int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;
        
        for(int i=0; i<n; i++){
            if(!visited[i]){
                bfs(i, computers);
                answer++;
            }
        }
        
        return answer;
    }
    
    public void bfs(int start, int[][] computers){
        Queue<Integer> que = new LinkedList<>();
        que.offer(start);
        visited[start] = true;
        int len = computers[0].length;
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int i=0; i<len; i++){
                if(!visited[i] && computers[cur][i]==1){
                    que.offer(i);
                    visited[i]=true;
                }
            }
        }
        
    }
}