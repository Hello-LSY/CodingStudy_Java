class Solution {
    static int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        
        dfs(numbers, target, 0, 0);
        
        return answer;
    }
    
    private void dfs(int[] numbers, int target, int depth, int sum){
        
        if(depth==numbers.length){
            if(target==sum)answer++;
        }else{
            dfs(numbers, target, depth+1, sum+numbers[depth]);
            dfs(numbers, target, depth+1, sum-numbers[depth]);
        }
    }
}