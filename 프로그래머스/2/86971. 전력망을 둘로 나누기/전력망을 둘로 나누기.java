import java.util.*;

class Solution {
    static int[][] graph; // 인접 행렬을 통해 송전탑 연결 상태를 저장
    public int solution(int n, int[][] wires) {
        int answer = n; // 초기값을 n으로 설정
        graph = new int[n+1][n+1]; // 인접 행렬 생성
        
        // 인접 행렬을 통해 송전탑 연결 정보 저장
        for(int i=0; i<wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        
        // 각 전선을 하나씩 끊어보고 BFS로 두 전력망의 크기 차이를 계산
        for(int i=0; i<wires.length; i++){
            int from = wires[i][0];
            int to = wires[i][1];
            graph[from][to] = 0; // 전선을 끊음
            graph[to][from] = 0;
            
            // 끊긴 상태에서 두 전력망의 크기 차이 계산
            answer = Math.min(answer, bfs(from, n));
            
            // 전선을 다시 연결
            graph[from][to] = 1;
            graph[to][from] = 1;
        }
        
        return answer; // 두 전력망의 크기 차이의 최소값 반환
    }
    
    public static int bfs(int start, int n){
        boolean[] visited = new boolean[n+1]; // 방문 여부 확인 배열
        int count = 1; // 시작 송전탑 포함
        
        Queue<Integer> que = new LinkedList<>(); // BFS를 위한 큐
        visited[start] = true; // 시작 송전탑 방문 처리
        que.add(start); // 큐에 시작 송전탑 추가
        
        // BFS 수행
        while(!que.isEmpty()){
            int cur = que.poll(); // 큐에서 송전탑 하나 꺼내기
            
            for(int i=1; i<=n; i++){
                // 현재 송전탑과 연결된 송전탑 중 방문하지 않은 송전탑 찾기
                if(graph[cur][i] == 1 && !visited[i]){
                    visited[i] = true; // 방문 처리
                    que.add(i); // 큐에 추가
                    count++; // 송전탑 개수 증가
                }
            }
        }
        
        // 두 전력망의 송전탑 개수 차이의 절대값 반환
        return (int)Math.abs(count-(n-count));
    }
}
