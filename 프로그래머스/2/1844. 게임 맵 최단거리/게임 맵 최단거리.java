import java.util.*;

class Solution {
    public static final int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
    public static boolean[][] visited;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        return bfs(maps);
    }
    
    private int bfs(int[][] maps){
        Queue<int[]>que = new LinkedList<>();
        // 처음 좌표기준 +1
        que.offer(new int[]{0,0,1});
        visited[0][0] = true;
        while(!que.isEmpty()){
            int[] cur = que.poll();
            int x = cur[0];
            int y = cur[1];
            int cnt = cur[2];
            
            if(x==maps.length-1 && y==maps[0].length-1){
                 return cnt;
            }else{
               for(int i=0; i<4; i++){
                   int dx = x+dir[i][0];
                   int dy = y+dir[i][1];
                   if(dx<maps.length && dy<maps[0].length && dx>=0 && dy>=0 &&
                      !visited[dx][dy] && maps[dx][dy]!=0){
                       que.offer(new int[]{dx, dy, cnt+1});
                       visited[dx][dy] = true;
                   }
               } 
            }
        }
        return -1;

    }
    
}