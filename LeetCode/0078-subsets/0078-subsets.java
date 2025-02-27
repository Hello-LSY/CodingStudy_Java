class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        dfs(nums, 0, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int[]nums, int start, List<Integer>list, List<List<Integer>>result){
        result.add(new ArrayList<>(list));

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            dfs(nums, i+1, list, result);
            list.remove(list.size()-1);
        }

    } 
}