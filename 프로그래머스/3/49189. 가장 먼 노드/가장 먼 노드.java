import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        int maxDis = 0;
        List<List<Integer>> graph = new ArrayList<>();
        // 간선의 수 = n + 1
        // 노드 추가
        for(int i=0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        
        // 간선 연결
        for(int[] e : edge){
            int x = e[0];
            int y = e[1];
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        
        int[]dis = bfs(graph, n);
        for(int d : dis){
            if(d>maxDis){
                maxDis=d;
                answer=1;
            }else if(d==maxDis){
                answer++;
            }
        }
        
        return answer;
    }
    
    
    private int[] bfs(List<List<Integer>> graph, int n){
        int[] dis = new int[n+1];
        boolean[] visited = new boolean[n+1];
        
        Queue<Integer> que = new LinkedList<>();
        que.offer(1);
        visited[1]=true;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            for(int next : graph.get(cur)){
                if(!visited[next]){
                    dis[next] = dis[cur] + 1;
                    que.offer(next);
                    visited[next]=true;
                }
            }
        }
        return dis;
    }
}