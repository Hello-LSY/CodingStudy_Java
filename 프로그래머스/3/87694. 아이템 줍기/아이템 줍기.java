import java.util.*;

class Solution {
    
    static class Point{
            int x;
            int y;
            int cnt;
            
            public Point(int x, int y, int cnt){
                this.x = x;
                this.y = y;
                this.cnt = cnt;
            }
    }
    
    //2배해주기; 안해주면 첫번째 그림 좌표[3,5] [4,5] [4,6] [3,6]처럼 테두리가 U형태로 나오는부분은 1,1,1,1 로 표현돼서 최단거리가 오류발생함
    int[][] map = new int[101][101];
    int[][] moveSet = {{1,0}, {0,1}, {-1,0}, {0,-1}};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
    
        int answer = 0;
        
        
        //테두리 = 1 내부 = 2로 초기화
        for(int[] point : rectangle){
            int startX= point[0]*2;
            int startY= point[1]*2;
            int endX = point[2]*2;
            int endY = point[3]*2;
            
            for(int i = startX; i<=endX; i++){
                for(int j = startY; j<=endY; j++){
                    if((map[i][j])==2)continue;
                    //테두리 1로 초기화
                    if(i==startX || i==endX || j==startY || j==endY)map[i][j]=1;
                    else map[i][j]=2;
                }
            }
        }
        
        answer = bfs(characterX*2, characterY*2, itemX*2, itemY*2);
        return answer;
    }
    
    public int bfs(int characterX, int characterY, int itemX, int itemY){
        Queue<Point> que = new LinkedList<>();
        boolean[][] visited = new boolean [map.length][map.length];
        int cnt=0;
        que.add(new Point(characterX, characterY, cnt));
        
        while(!que.isEmpty()){
            Point cur = que.poll();
            
            if(cur.x == itemX && cur.y == itemY){
                return cur.cnt/2;
            }
            
            for(int[] move : moveSet){
                int nextX = cur.x + move[0];
                int nextY = cur.y + move[1];
                
                if (nextX >= 0 && nextX <= 100 && nextY >= 0 && nextY <= 100) {
                    if (!visited[nextX][nextY] && map[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        que.add(new Point(nextX, nextY, cur.cnt + 1));
                    }
                }

            } 
        }
        
        return -1;
        
    }
}