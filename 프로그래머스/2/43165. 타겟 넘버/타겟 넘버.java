class Solution {
    public static int answer;
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, target, 0, numbers.length);
        
        return answer;
    }

    private void dfs(int[] numbers, int start, int target, int depth, int end){
        if(depth==end){
            if(start==target) answer++;
        } else{
            dfs(numbers, start+numbers[depth], target, depth+1, end);
            dfs(numbers, start-numbers[depth], target, depth+1, end);
        }
        
    }
}