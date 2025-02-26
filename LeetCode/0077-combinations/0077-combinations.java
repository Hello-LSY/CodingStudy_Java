class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, 1, new ArrayList<>(), result);

        return result;
    }

    private void dfs(int n, int k, int start, List<Integer>nums, List<List<Integer>>result){
        if(nums.size()==k){
            result.add(new ArrayList<>(nums));
            return;
        }

        for(int i=start; i<=n; i++){
            nums.add(i);
            dfs(n,k,i+1,nums,result);
            nums.remove(nums.size()-1);
        }
    }


}