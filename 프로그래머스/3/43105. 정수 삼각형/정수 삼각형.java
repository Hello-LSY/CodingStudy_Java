class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;

        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    // 삼각형 왼쪽
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j == triangle[i].length - 1) {
                    // 삼각형 오른쪽
                    triangle[i][j] += triangle[i - 1][j - 1];
                } else {
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }
        }

        int end = triangle.length - 1;
        for (int i = 0; i < triangle[end].length; i++) {
            answer = Math.max(answer, triangle[end][i]);
        }

        return answer;
    }
}
