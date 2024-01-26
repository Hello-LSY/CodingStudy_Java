class Solution {
    public int solution(int M, int N) {
        int answer = 0;
        int cut_M = M;
        int cut_N = N;
        while(cut_M!=1){
            answer++;
            cut_M--;
        }
        for(int i=0; i<M; i++){
            cut_N=N;
            while(cut_N!=1){
                answer++;
                cut_N--;
            }
        }
        
        return answer;
    }
}