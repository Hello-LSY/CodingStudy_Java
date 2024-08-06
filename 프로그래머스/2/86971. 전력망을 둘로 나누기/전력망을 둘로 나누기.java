import java.util.*;
class Solution {
    static int[][] graph;
    public int solution(int n, int[][] wires) {
        int answer = n;
        //인접행렬 파악
        graph = new int[n+1][n+1];
        
        for(int i=0; i<wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        
        for(int i=0; i<wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            //해제해보고 세보기
            graph[from][to] = 0;
            graph[to][from] = 0;
            answer = Math.min(answer, bfs(n, from));
            
            graph[from][to] = 1;
            graph[to][from] = 1;        
        }
        
        return answer;
    }
    
    public static int bfs(int n, int start){
        boolean[] visited = new boolean[n+1];
        Queue<Integer>que = new LinkedList<>();
        int count = 1;
        visited[start] = true;
        que.add(start);
        
        while(!que.isEmpty()){
            int cur = que.poll();
            
            for(int i=1; i<=n; i++){
                if(graph[cur][i]==1 && !visited[i]){
                    visited[i]=true;
                    que.add(i);
                    count++;
                }
            }
            
        }
        return (int)Math.abs(count-(n-count));
    }
    
}