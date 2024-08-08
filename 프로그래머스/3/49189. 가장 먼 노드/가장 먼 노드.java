import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        // 그래프를 인접 리스트 형태로 생성
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0]).add(e[1]);
            graph.get(e[1]).add(e[0]);
        }
        
        // BFS를 이용해 최단 거리 계산
        int[] dist = bfs(graph, n);
        
        // 가장 멀리 떨어진 노드의 개수를 계산
        int maxDist = 0;
        int cnt = 0;
        
        for (int d : dist) {
            if (d > maxDist) {
                maxDist = d;
                cnt = 1;
            } else if (d == maxDist) {
                cnt++;
            }
        }
        
        return cnt;
    }

    private int[] bfs(List<List<Integer>> graph, int n) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        dist[1] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph.get(cur)) {
                if (dist[next] == -1) {
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        return dist;
    }
}
