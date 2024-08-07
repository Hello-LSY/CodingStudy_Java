import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = buildGraph(n, edge);
        int[] dist = bfs(graph, n);
        return countFurthest(dist);
    }

    private List<List<Integer>> buildGraph(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] e : edge) {
            graph.get(e[0] - 1).add(e[1] - 1);
            graph.get(e[1] - 1).add(e[0] - 1);
        }
        
        return graph;
    }
    
    private int[] bfs(List<List<Integer>> graph, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        dist[0] = 0;
        
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

    private int countFurthest(int[] dist) {
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
}
