import java.util.*;

class Solution {
    private List<List<Integer>> comb;
    // private boolean[] visited;

    public List<List<Integer>> combine(int n, int k) {
        comb = new ArrayList<>();
        // visited = new boolean[n + 1];
        List<Integer> curComb = new ArrayList<>();
        
        dfs(n, k, 1, curComb);
        
        return comb;
    }

    private void dfs(int n, int k, int start, List<Integer> curComb) {
        //완성되면 넣기
        if (curComb.size() == k) {
            comb.add(new ArrayList<>(curComb));
            return;
        }

        for (int i = start; i <= n; i++) {
            
                // visited[i] = true;
                curComb.add(i);
                
                dfs(n, k, i + 1, curComb);
                
                curComb.remove(curComb.size() - 1);
                // visited[i] = false;
            
        }
    }
}