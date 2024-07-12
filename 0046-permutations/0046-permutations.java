import java.util.*;

class Solution {
    private boolean[] visited;
    private List<List<Integer>> perm;

    public List<List<Integer>> permute(int[] nums) {
        visited = new boolean[nums.length];
        perm = new ArrayList<>();
        List<Integer> curPerm = new ArrayList<>();
        
        dfs(nums, curPerm);
        
        return perm;
    }

    private void dfs(int[] nums, List<Integer> curPerm) {
        //순열생성됐으면 넣음
        if (curPerm.size() == nums.length) {
            perm.add(new ArrayList<>(curPerm));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                curPerm.add(nums[i]);

                dfs(nums, curPerm);

                curPerm.remove(curPerm.size() - 1);
                visited[i] = false;

            }
        }
    }
}