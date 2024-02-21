import java.util.*;

class Solution {
    
    List<int[]> list = new ArrayList<>();
    
    public int[][] solution(int n) {
        int[][] answer = new int[(int) Math.pow(2, n) - 1][2];
        
        dfs(n, 1, 2, 3);
        
        int cnt = 0;
        for (int[] arr : list) {
            answer[cnt++] = arr;
        }
        
        return answer;
    }
    
    // from: 옮기는 원판 by: 임시 위치 to: 최종 위치
    private void dfs(int n, int from, int by, int to) {
        int[] move = {from, to};
        if (n == 1) {
            list.add(move);
            return;
        }
        // 1->3(임시)->2 순서로 최종적으로 2번에 원판을 옮김 
        dfs(n - 1, from, to, by);
        // 1->3 순서로 최종적으로 3번에 원판을 옮김
        list.add(move);
        // 2->1(임시)->3 순서로 최종적으로 3번에 원판을 옮김 
        dfs(n - 1, by, from, to);
    }
}
