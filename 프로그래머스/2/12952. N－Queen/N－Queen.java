class Solution {
    private int answer;
    private boolean[] cols;
    private boolean[] d1; // 좌하향 대각선
    private boolean[] d2; // 우하향 대각선
    
    public int solution(int n) {
        answer = 0;
        cols = new boolean[n];
        d1 = new boolean[2 * n - 1];
        d2 = new boolean[2 * n - 1];
        
        dfs(0, n);
        
        return answer;
    }
    
    private void dfs(int row, int n) {
        if (row == n) {
            answer++;
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int id1 = row - col + n - 1;
            int id2 = row + col;
            if (cols[col] || d1[id1] || d2[id2]) {
                continue;
            }
            
            cols[col] = true;
            d1[id1] = true;
            d2[id2] = true;
            dfs(row + 1, n);
            cols[col] = false;
            d1[id1] = false;
            d2[id2] = false;
        }
    }
}
