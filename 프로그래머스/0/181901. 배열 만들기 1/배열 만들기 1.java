class Solution {
    public int[] solution(int n, int k) {
        int len = n/k;
        int[] answer = new int[len];
        for(int i=1, j=0; i<n+1; i++){
            if(i%k==0){
                answer[j] = i;
                j++;
            }
        }
        
        return answer;
    }
}