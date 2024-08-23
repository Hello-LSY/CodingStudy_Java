import java.util.*;
class Solution {

	public int networkDelayTime(int[][] times, int n, int k) {
		
		//그래프 경로를 배열로 저장
        int[][] vertex = new int[n+1][n+1];
        for(int[]v : vertex){
            Arrays.fill(v, -1);
        }
        for(int[] time : times){
            vertex[time[0]][time[1]] = time[2];
        }
        int[] disQue = new int[n+1];
        Arrays.fill(disQue, Integer.MAX_VALUE);
        disQue[k]=0;
		boolean[] visited = new boolean[n+1];
		//다익스트라		
		dijkstra(vertex, disQue, visited, k, n);
		
		Arrays.sort(disQue);
		
		return disQue[n-1] == Integer.MAX_VALUE ? -1 : disQue[n-1];
	}

	private void dijkstra(int[][] vertex, int[] disQue, boolean[] visited, int k, int n) {
        for(int i=1; i<=n; i++){
            int min = findMin(disQue, visited);
            visited[min] = true;
            for(int j = 1; j<=n; j++){
                int newRoute = disQue[min] + vertex[min][j];
                if(!visited[j] && vertex[min][j] != -1 && newRoute < disQue[j]){
                    disQue[j] = newRoute;
                }
            }
        }
		
	}

	private int findMin(int[] disQue, boolean[] visited) {
		int minV = Integer.MAX_VALUE;
        int minI = -1;
        for(int i=1; i<disQue.length; i++){
            if(!visited[i] && disQue[i]<=minV){
                minV = disQue[i];
                minI = i;
            }
        }
        return minI;
	}
}