import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        boolean[][] route = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int i = 0; i < edge.length; i++) {
            route[edge[i][0]][edge[i][1]] = true;
            route[edge[i][1]][edge[i][0]] = true;
        }

        answer = bfs(1, route, visited);

        return answer;
    }

    private int bfs(int start, boolean[][] route, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        int count = 0;

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            count = size; // 현재 큐의 크기를 count에 저장

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                for (int j = 1; j < route[current].length; j++) {
                    if (route[current][j] && !visited[j]) {
                        queue.add(j);
                        visited[j] = true;
                    }
                }
            }
        }

        return count;
    }
}
