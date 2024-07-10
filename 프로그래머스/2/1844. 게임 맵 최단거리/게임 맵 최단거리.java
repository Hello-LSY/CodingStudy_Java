import java.util.*;

class Solution {
    private static final int[][] move = {{-1,0}, {0,-1}, {1,0}, {0,1}};
    private static boolean[][] visited; 
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        visited = new boolean[maps.length][maps[0].length];
        
        return bfs(maps);
    }
    
    private int bfs(int[][] maps){
        Queue<int[]>que = new LinkedList<>();
        que.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int dis = cur[2];
            
            //도착함
            if(x==maps.length-1 && y==maps[0].length-1){
                return dis;
            }else{
                for(int i=0; i<4; i++){
                    int moveX = x + move[i][0];
                    int moveY = y + move[i][1];
                    
                    //벽까지감
                    if(moveX>=maps.length || moveX<0 || moveY>=maps[0].length || moveY<0) continue;
                    if(!visited[moveX][moveY] && maps[moveX][moveY]==1){
                        que.offer(new int[]{moveX, moveY, dis+1});
                        visited[moveX][moveY] = true;
                    }
                }
            }
        }
        return -1;
    }
}