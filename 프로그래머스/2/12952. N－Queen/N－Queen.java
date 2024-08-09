class Solution {
    private static int answer;
    private static int[] queens;
    
    public int solution(int n) {
        answer = 0;
        queens = new int[n];
        
        dfs(0, n);
        
        return answer;
    }
    
    private void dfs(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            // 퀸 배치 가능한지 로직필요
            if (isValid(row, col)) {
                queens[row] = col;
                dfs(row + 1, n);
            }
        }
    }
    
    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            // i번째 행의 퀸과 현재 배치하려는 퀸의 행,열차이 
            if (queens[i] == col || Math.abs(queens[i] - col) == Math.abs(i - row)) {
                return false;
            }
            
        }
        return true;
    }
}
