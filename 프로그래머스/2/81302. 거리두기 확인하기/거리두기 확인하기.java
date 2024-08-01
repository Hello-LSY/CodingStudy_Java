import java.util.*;

class Solution {
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        // 대기실 완탐
        for (int i = 0; i < places.length; i++) {
            if (checkDis(places[i])) {
                answer[i] = 1;
            // 거리두기 안지킨 경우
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }

    private boolean checkDis(String[] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                // 사람이 앉아있을때 완탐
                if (place[i].charAt(j) == 'P') {
                    if (!bfs(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    private boolean bfs(String[] place, int x, int y) {
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[5][5];
        que.offer(new int[]{x, y});
        visited[x][y] = true;
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                // 아직 방문 안한경우 && 맵 안에 있는 경우
                if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && !visited[nx][ny]) {
                    // 맨허튼 거리 구하기
                    int manDis = Math.abs(nx - x) + Math.abs(ny - y);
                    
                    if (manDis <= 2) {
                        visited[nx][ny] = true;
                        // 맨허튼 안지킴
                        if (place[nx].charAt(ny) == 'P') {
                            return false;
                        } else if (place[nx].charAt(ny) == 'O') {
                            que.offer(new int[]{nx, ny});
                        }
                    }
                }
            }
        }
        
        return true;
    }
}
