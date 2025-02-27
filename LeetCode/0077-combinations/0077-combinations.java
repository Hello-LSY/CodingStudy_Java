class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(n,k,1, list, result);

        return result;
    }

    private void dfs(int n, int k, int start, List<Integer> list, List<List<Integer>>result){
        if(list.size()==k){
            result.add(new ArrayList<>(list));
        }

        for(int i = start; i<n+1; i++){
            list.add(i);
            dfs(n, k, i+1, list, result);
            list.remove(list.size()-1);
        }
    }
}