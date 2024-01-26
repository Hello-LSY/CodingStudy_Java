class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        int[] sum_score = new int[score.length];
        
        for(int i=0; i<score.length; i++){
            answer[i]++;
            sum_score[i] = score[i][1] + score[i][0];
        }
        
        for(int i=0; i<score.length; i++){
            for(int j=0; j<score.length; j++){
                if(sum_score[i]<sum_score[j])answer[i]++;
            }
        }
        
        return answer;
    }
}