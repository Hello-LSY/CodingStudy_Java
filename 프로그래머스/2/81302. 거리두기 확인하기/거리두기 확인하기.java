import java.util.*;

class Solution {
    public static final int[][] move = {{0,1}, {0,-1}, {1,0}, {-1,0}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for (int i = 0; i < places.length; i++) {
            if (checkDis(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private boolean checkDis(String[] place) {
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[0].length(); j++) {
                if (place[i].charAt(j) == 'P') {
                    if (!bfs(place, i, j)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    private boolean bfs(String[] place, int xPos, int yPos) {
        boolean[][] visited = new boolean[place.length][place[0].length()];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{xPos, yPos, 0});
        visited[xPos][yPos] = true;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];
            
            // 거리가 1일 때 다른 P를 발견하면 바로 실패 처리
            if (dist > 0 && place[x].charAt(y) == 'P') {
                return false;
            }
            
            // BFS 탐색의 거리를 2로 제한
            if (dist < 2) {
                for (int i = 0; i < 4; i++) {
                    int nx = x + move[i][0];
                    int ny = y + move[i][1];
                    
                    if (nx >= 0 && ny >= 0 && nx < place.length && ny < place[0].length() && !visited[nx][ny]) {
                        // 파티션('X')이 없는 경우에만 다음 위치로 이동
                        if (place[nx].charAt(ny) != 'X') {
                            queue.offer(new int[]{nx, ny, dist + 1});
                        }
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        
        return true;
    }
}
