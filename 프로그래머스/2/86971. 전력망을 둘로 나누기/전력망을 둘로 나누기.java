import java.util.*;
class Solution {
    
    private static boolean[] visited;
    static int min;
    static int[][] arr;
    
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;        
        arr = new int[n+1][n+1];   
        
        for(int i=0; i<wires.length; i++){
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }
        
        for(int i=0; i<wires.length; i++){
            int cutLeft = wires[i][0];
            int cutRight = wires[i][1];
            
            arr[cutLeft][cutRight] = 0;
            arr[cutRight][cutLeft] = 0;
            
            answer = Math.min(answer, bfs(cutLeft, n));
            
            arr[cutLeft][cutRight] = 1;
            arr[cutRight][cutLeft] = 1;
        }
        
        return answer;
    }
    
    public int bfs(int start, int n){
        Queue<Integer> que = new LinkedList<>();
        visited = new boolean[n+1];
        que.offer(start);
        int cnt = 1;
        visited[start]=true;
        
        while(!que.isEmpty()){
            int cur = que.poll();
            visited[cur] = true;
            
            for(int i=0; i<=n; i++){
                if(arr[cur][i] ==1 && !visited[i]){
                    que.offer(i);
                    cnt++;
                }
            }
        }
        return Math.abs(cnt - (n - cnt));
    }
    
}