import java.util.*;

class Solution {
    
    private static final int[] xMove = {-1,1,0,0}; 
    private static final int[] yMove = {0,0,-1,1}; 
    private static boolean visited[][];
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        
        return bfs(maps);
    }
    
    private int bfs(int[][] maps){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            int[]cur = que.poll();
            int xPos = cur[0];
            int yPos = cur[1];
            int dis = cur[2];
            
            if(xPos==maps.length-1 && yPos==maps[0].length-1){
                return dis;
            }else{
                for(int i=0; i<4; i++){
                    int dx = xPos + xMove[i];
                    int dy = yPos + yMove[i];
                    
                    if(dx<0 || dx>=maps.length || dy<0 || dy>=maps[0].length) continue;
                    if(!visited[dx][dy] && maps[dx][dy]==1){
                        que.add(new int[]{dx, dy, dis+1});
                        visited[dx][dy]=true;
                    }                
                    
                }
            }
        }
        return -1;
    }
}