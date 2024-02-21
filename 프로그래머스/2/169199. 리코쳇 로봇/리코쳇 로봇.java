import java.util.LinkedList;
import java.util.Queue;

class Point {
    int x;
    int y;

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
class Solution {
    int N, M;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] board) {
        N = board.length;
        M = board[0].length();
        int[][] visited = new int[N][M];
        Queue<Point> q = new LinkedList<>();

        for (int i = 0; i < N; ++i) {
            String s = board[i];
            for (int j = 0; j < M; ++j) {
                if (s.charAt(j) == 'R') {
                    q.add(new Point(i, j));
                    visited[i][j] = 1;
                    break;
                }
            }
        }
        int answer = bfs(board, visited, q);
        return answer;
    }

    private int bfs(String[] board, int[][] visited, Queue<Point> q) {
        int answer = -1;
        while (!q.isEmpty()) {
            Point cur = q.poll();

            if (board[cur.x].charAt(cur.y) == 'G') {
                answer = visited[cur.x][cur.y] - 1;
                break;
            }

            for (int d = 0; d < 4; d++) {
                int nextX = cur.x;
                int nextY = cur.y;

                while (isInRange(nextX + dx[d], nextY + dy[d]) && board[nextX + dx[d]].charAt(nextY + dy[d]) != 'D') {
                    nextX += dx[d];
                    nextY += dy[d];
                }

                if (isInRange(nextX, nextY) && visited[nextX][nextY] == 0) {
                    q.add(new Point(nextX, nextY));
                    visited[nextX][nextY] = visited[cur.x][cur.y] + 1;
                }

            }
        }

        return answer;
    }

    public boolean isInRange(int x, int y) {
        return 0 <= x && x < N && 0 <= y && y < M;
    }
}
