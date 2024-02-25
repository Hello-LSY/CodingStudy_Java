class Solution {
    public int[] solution(int n) {
        int length = n * (n+1) / 2;
        int[] answer = new int[length];
        int[][] arr = new int[n][n];
        
        int row = -1, col = 0, cnt = 1;
        
        // 달팽이 채우기
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i % 3 == 0) {
                    row++;
                } else if (i % 3 == 1) {
                    col++;
                } else if (i % 3 == 2) {
                    row--;
                    col--;
                }
                arr[row][col] = cnt++;
            }
        }
        
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                answer[idx++] = arr[i][j];
            }
        }
        
        return answer;
    }
}
