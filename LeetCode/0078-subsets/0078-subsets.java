import java.util.*;

class Solution {
    private List<List<Integer>> sSets;

    public List<List<Integer>> subsets(int[] nums) {
        sSets = new ArrayList<>();
        dfs(nums, new ArrayList<>(), 0);
        return sSets;
    }
    
    private void dfs(int[] nums, List<Integer> sSet, int start) {
        //모든 경우에 추가
        sSets.add(new ArrayList<>(sSet));

        for (int i = start; i < nums.length; i++) {
            sSet.add(nums[i]);
            
            dfs(nums, sSet, i + 1);
            
            sSet.remove(sSet.size() - 1);
        }
    }
}