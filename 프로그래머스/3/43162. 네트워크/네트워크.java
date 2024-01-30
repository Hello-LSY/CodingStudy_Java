import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, n, computers, visited);
                answer++;
            }
        }
        return answer;
    }
    
    public static void bfs(int start, int n, int[][] computers, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int i = 0; i < n; i++) {
                if (computers[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
    
    
}