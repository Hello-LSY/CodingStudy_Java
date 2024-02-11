class Solution {
    int solution(int[][] land) {
        int answer = 0;
        
        for (int i = 1; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                land[i][j] += maxOfPreviousRow(land, i - 1, j);
            }
        }

        for (int j = 0; j < land[0].length; j++) {
            answer = Math.max(answer, land[land.length - 1][j]);
        }

        return answer;
    }

    private int maxOfPreviousRow(int[][] land, int row, int col) {
        int max = 0;
        for (int j = 0; j < land[0].length; j++) {
            if (j != col) {
                max = Math.max(max, land[row][j]);
            }
        }
        return max;
    }
}
