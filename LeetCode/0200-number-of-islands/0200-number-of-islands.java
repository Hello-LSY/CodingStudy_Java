class Solution {
    public int numIslands(char[][] grid) {
        int numIslands = 0;
        int m = grid.length;
        int n = grid[0].length;
        
        // 무조건 완탐
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 문자열 1 찾으면 섬의 개수 증가
                if (grid[i][j] == '1') {
                    numIslands += 1;
                    dfs(grid, i, j, m, n);
                }
            }
        }

        return numIslands;
    }

    private void dfs(char[][] grid, int i, int j, int m, int n) {
        // 경계 벗어나면 리턴
        if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == '0') {
            return;
        }

        // 문자열 0으로 방문처리
        grid[i][j] = '0';

        // 상하좌우 재귀
        dfs(grid, i - 1, j, m, n); // 위
        dfs(grid, i + 1, j, m, n); // 아래
        dfs(grid, i, j - 1, m, n); // 왼
        dfs(grid, i, j + 1, m, n); // 오
    }
}
