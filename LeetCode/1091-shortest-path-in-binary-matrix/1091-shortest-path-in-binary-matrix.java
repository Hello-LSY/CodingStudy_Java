import java.util.*;

class Solution {
    private static final int[][] move = {
        {1, 0}, {-1, 0}, {0, 1}, {0, -1}, 
        {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        
        // 최적화 로직
        if (grid[0][0] != 0 || grid[n - 1][n - 1] != 0) {
            return -1;
        }
        
        return bfs(grid, n);
    }

    private int bfs(int[][] grid, int n) {
        Queue<int[]> que = new LinkedList<>();
        que.offer(new int[]{0, 0});
        grid[0][0] = 1; // visited안씀

        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int pLen = grid[x][y];
            
            // 도착하면 리턴
            if (x == n - 1 && y == n - 1) {
                return pLen;
            }
            // 이웃탐색 모듈화
            findNeighbors(que, grid, x, y, pLen, n);
        }
        
        // 다돌려도 없음
        return -1;
    }
    
    // 이웃탐색 로직
    private void findNeighbors(Queue<int[]> que, int[][] grid, int x, int y, int pLen, int n) {
        for (int[] dir : move) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            
            if (isInBounds(nx, ny, n) && grid[nx][ny] == 0) {
                que.offer(new int[]{nx, ny});
                grid[nx][ny] = pLen + 1;
            }
        }
    }
    
    // 범위 체크 모듈화
    private boolean isInBounds(int x, int y, int n) {
        return x >= 0 && y >= 0 && x < n && y < n;
    }
}
