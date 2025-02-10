class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>>result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        dfs(nums, new ArrayList<>(), result, visited);
        return result;
    }
    
    private void dfs(int[] nums, List<Integer> num, List<List<Integer>>result, boolean[]visited){
        if(num.size()==nums.length){
            result.add(new ArrayList<>(num));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(!visited[i]){
                visited[i]=true;
                num.add(nums[i]);
                dfs(nums, num, result, visited);
                num.remove(num.size()-1);
                visited[i]=false;
            }
        }
    }
}