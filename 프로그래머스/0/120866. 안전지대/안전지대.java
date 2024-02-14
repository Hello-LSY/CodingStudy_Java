class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int[][] flag = {{-1, -1}, {0, -1}, {1, -1},
                        {-1, 0}, {0, 0}, {1, 0},
                        {-1, 1}, {0, 1}, {1, 1}};
        
        int[][] check = new int[board.length + 2][board.length + 2];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == 1) {
                    for (int k = 0; k < flag.length; k++) {
                        int x = flag[k][1];
                        int y = flag[k][0];
                        check[i + y + 1][j + x + 1]++;
                    }
                }
            }
        }
        
        for (int i = 1; i < check.length-1; i++) {
            for (int j = 1; j < check.length-1; j++) {
                if (check[i][j]==0) answer++;
            }
        }
        
        return answer;
    }
}
