class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();

        dfs(nums, 0, result, new ArrayList<>());

        return result;
    }

    private void dfs(int[] nums, int start, List<List<Integer>>result, List<Integer> list){
        result.add(new ArrayList<>(list));

        for(int i=start; i<nums.length; i++){
            list.add(nums[i]);
            dfs(nums, i+1, result, list);
            list.remove(list.size()-1);
        }

    }
}