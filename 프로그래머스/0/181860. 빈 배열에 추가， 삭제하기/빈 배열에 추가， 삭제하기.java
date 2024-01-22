import java.util.Stack;

class Solution {
    public int[] solution(int[] arr, boolean[] flag) {
        Stack<Integer> result = new Stack<>();
        
        for(int i=0; i<arr.length; i++){
            if(flag[i]==true){
                for(int j=0; j<arr[i]*2; j++){
                    result.push(arr[i]);
                }
            }else{
                for(int j=0; j<arr[i]; j++){
                    if(!result.isEmpty())result.pop();
                }
            }
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = result.size() - 1; i >= 0; i--) {
            answer[i] = result.pop();
        }
        
        return answer;
    }
}