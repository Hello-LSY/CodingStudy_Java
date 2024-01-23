class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        final int RIGHT = 0;
        final int DOWN = 1;
        final int LEFT = 2; 
        final int UP = 3;
        
        int cnt = 1;
        int row = 0;
        int col = 0;
        int direction = RIGHT;
        
        int[][] moves = {{0, 1},
                         {1, 0}, 
                         {0, -1},
                         {-1, 0}};
        
        for (int i = 0; i < n * n; i++) {
            answer[row][col] = cnt++;
            
            int nextRow = row + moves[direction][0];
            int nextCol = col + moves[direction][1];
            
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || answer[nextRow][nextCol] != 0) {
                direction = (direction + 1) % 4;
            }
            
            row += moves[direction][0];
            col += moves[direction][1];
        }
        
        return answer;
    }
}
