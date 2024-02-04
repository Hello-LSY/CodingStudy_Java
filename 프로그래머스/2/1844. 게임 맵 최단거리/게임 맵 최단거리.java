import java.util.*;

class Solution {
    
    int[] moveX = {-1,1,0,0};
    int[] moveY = {0,0,1,-1};
    
    public int solution(int[][] maps) {        
        boolean[][]visited = new boolean[maps.length][maps[0].length];
        return bfs(maps, visited);
    }
    
    public int bfs(int[][] maps, boolean[][] visited){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0,0,1});//캐릭터 좌표,거리
        visited[0][0]= true;
        
        while(!que.isEmpty()){
            
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int distance = cur[2];
            
            if(x==maps.length-1 && y==maps[0].length-1)return distance;
            
            for(int i=0; i<4; i++){
                int dx = x + moveX[i];
                int dy = y + moveY[i];
                
                if(dx < 0 || dx >= maps.length || dy < 0 || dy >= maps[0].length) continue;
                if(!visited[dx][dy] && maps[dx][dy]==1){
                    visited[dx][dy]=true;
                    que.add(new int[]{dx,dy, distance+1});
                }  
            }            
        }
        return -1;    
    }
}