class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] right = {0,1};
        int[] left = {0,-1};
        int[] up = {-1,0};
        int[] down = {1,0};
        
        int[][] move = {right, down, left, up};
        int cnt=0;
        int X=0;
        int Y=0;
        
        for (int i = 1; i <= n * n; i++) {
            answer[Y][X] = i;
            
            int nextX = X + move[cnt][1];
            int nextY = Y + move[cnt][0];
            
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || answer[nextY][nextX] != 0) {
                cnt = (cnt + 1) % 4;
                nextX = X + move[cnt][1];
                nextY = Y + move[cnt][0];
            }
            
            X = nextX;
            Y = nextY;
        }
        return answer;
    }
}
