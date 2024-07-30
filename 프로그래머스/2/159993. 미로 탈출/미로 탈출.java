import java.util.*;

class Solution {
    private static boolean[][] visited;
    private static final int[] xMove = {0, 0, -1, 1};
    private static final int[] yMove = {1, -1, 0, 0};
    
    public int solution(String[] maps) {
        int answer = 0;
        int n = maps.length;
        int m = maps[0].length();
        
        // 출발 지점, 레버, 출구 위치 찾기
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // S가 0,0이 아닐 수 있으므로 어딘지 알아내야함
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        
        // 출발 지점에서 레버까지의 거리
        int disLever = bfs(maps, start, lever);
        if (disLever == -1) return -1; // 레버에 도달 불가능
        
        // 레버에서 출구까지의 거리
        int disExit = bfs(maps, lever, exit);
        if (disExit == -1) return -1; // 출구에 도달 불가능
        
        answer = disLever + disExit;
        return answer;
    }
    
    private int bfs(String[] maps, int[] start, int[] goal) {
        visited = new boolean[maps.length][maps[0].length()];
        Queue<Player> queue = new LinkedList<>();
        // Player생성자 : (x,y)좌표, 이동횟수
        queue.offer(new Player(start[0], start[1], 0));
        // 'S'위치 방문처리
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            Player current = queue.poll();
            int x = current.getxPos();
            int y = current.getyPos();
            int cnt = current.getmCnt();
            
            if (x == goal[0] && y == goal[1]) {
                return cnt;
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = x + xMove[i];
                int newY = y + yMove[i];
                
                // 미로를 벗어나지않는 좌표 && 방문하지 않은 좌표 && X(벽)가 아닌 좌표 
                if (newX >= 0 && newX < maps.length && newY >= 0 && newY < maps[0].length() 
                        && !visited[newX][newY] 
                        && maps[newX].charAt(newY) != 'X') {
                    queue.offer(new Player(newX, newY, cnt + 1));
                    visited[newX][newY] = true;
                }
            }
        }
        
        return -1; // 이동할 수 있는 공간이 없는 경우
    }
    
    class Player {
        private int xPos;
        private int yPos;
        private int mCnt;
        
        Player(int xPos, int yPos, int mCnt) {
            this.xPos = xPos;
            this.yPos = yPos;
            this.mCnt = mCnt;
        }
        
        public int getxPos() {
            return xPos;
        }
        
        public int getyPos() {
            return yPos;
        }
        
        public int getmCnt() {
            return mCnt;
        }
    }
}
