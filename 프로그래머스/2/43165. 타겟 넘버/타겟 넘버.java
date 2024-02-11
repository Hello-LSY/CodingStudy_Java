import java.util.*;
class Solution {
    int answer = 0;
    int[] cal = {1, -1};
    public int solution(int[] numbers, int target) {

        // dfs(numbers, target, 0, 0);
        
        answer= bfs(numbers, target);
        
        return answer;
    }
    
    private int bfs(int []numbers, int target){
        int depth = 1;
        
        Queue<Integer> queue = new LinkedList<>();
        for(int calculate : cal){
            queue.offer(numbers[0]*calculate);
        }
        
        while(depth < numbers.length){
            int size = queue.size();
            for(int i=0; i<size; i++){
                int cur = queue.poll();
                for(int calculate : cal) 
                    queue.offer(cur + numbers[depth]*calculate);
            }
            depth++;
        }
        
        while(!queue.isEmpty()){
            if(queue.poll()==target) answer++;
        }
        
        return answer++;
        
    }
        
//     private void dfs(int[]numbers, int target, int depth, int sum){
        
//         if(depth==numbers.length){
//             if(target==sum) answer++;
//         }
//         else{
//             dfs(numbers, target, depth+1, sum+numbers[depth]);
//             dfs(numbers, target, depth+1, sum-numbers[depth]);
//         }
//     }
}