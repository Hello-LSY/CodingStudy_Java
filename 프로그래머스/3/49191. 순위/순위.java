class Solution {
    public int solution(int n, int[][] results) {
        int answer = 0;
        int[][] floyd = new int[n + 1][n + 1];

        // 순위 갱신
        for (int i = 0; i < results.length; i++) {
            int A = results[i][0];
            int B = results[i][1];
            floyd[A][B] = 1;
            floyd[B][A] = -1;
        }

        // 플로이드-와샬 알고리즘 수행
        floydWarshall(n, floyd);

        // 결과 계산
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            for (int j = 1; j <= n; j++) {
                if (floyd[i][j] != 0) cnt++;
            }
            if (cnt == n - 1) answer++;
        }

        return answer;
    }

    private void floydWarshall(int n, int[][] floyd) {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (floyd[i][k] == 1 && floyd[k][j] == 1) {
                        floyd[i][j] = 1;
                        floyd[j][i] = -1;
                    }
                    if (floyd[i][k] == -1 && floyd[k][j] == -1) {
                        floyd[i][j] = -1;
                        floyd[j][i] = 1;
                    }
                }
            }
        }
    }
}
