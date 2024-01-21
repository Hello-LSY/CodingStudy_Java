class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        int result_sum = 0;
        int result_mul = 1;
        for(int i=0; i<num_list.length; i++){
            result_mul *= num_list[i];
            result_sum += num_list[i];
        }
        result_sum *= result_sum;
        return result_mul<result_sum ? 1:0;
    }
}