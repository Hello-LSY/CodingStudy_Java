class Solution {
    public int solution(int[] arr, int idx) {
        int answer = -1;
        int len = arr.length;
        for(int i=idx; i<len; i++){
            if(arr[i]==1) {
                answer=i;
                break;
            }
        }
        return answer;
    }
}