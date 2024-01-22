import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        
        int[]result = Arrays.stream(arr).distinct().toArray();
        
        int len = Math.min(result.length, k);
        for(int i=0; i<len; i++){
            answer[i] = result[i];
        }
           
        return answer;
    }
}