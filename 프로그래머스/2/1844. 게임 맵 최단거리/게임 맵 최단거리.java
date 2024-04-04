import java.util.*;

class Solution {
    
    int[] moveX = {-1, 1, 0, 0};
    int[] moveY = {0, 0, 1, -1};
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        boolean[][] visited = new boolean[n][m];
        
        int answer = bfs(maps, visited, n, m);
        
        return answer;
    }
    
    public int bfs(int[][] maps, boolean[][] visited, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1}); // 시작 지점 (0, 0)과 거리 1
        
        visited[0][0] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];
            int distance = cur[2];
            
            // 목적지에 도착했을 때 거리 반환
            if (curX == n - 1 && curY == m - 1) {
                return distance;
            }
            
            // 네 방향으로 이동
            for (int i = 0; i < 4; i++) {
                int nextX = curX + moveX[i];
                int nextY = curY + moveY[i];
                
                // 다음 위치가 범위 안에 있고, 벽이 아니며, 방문하지 않았다면 이동
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && maps[nextX][nextY] == 1 && !visited[nextX][nextY]) {
                    queue.add(new int[]{nextX, nextY, distance + 1});
                    visited[nextX][nextY] = true;
                }
            }
        }
        
        // 도착할 수 없는 경우
        return -1;
    }
}
