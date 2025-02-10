import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);
        return result;

    }

    private void dfs(int[]nums, int start, List<Integer>num, List<List<Integer>>result){
        result.add(new ArrayList<>(num));

        for(int i=start; i<nums.length; i++){
            num.add(nums[i]);
            dfs(nums, i+1, num, result);
            num.remove(num.size()-1);
        }

    } 

}