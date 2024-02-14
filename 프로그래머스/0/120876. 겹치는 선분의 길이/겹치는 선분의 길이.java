class Solution {
    public int solution(int[][] lines) {
        
        int answer=0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        //선만들기
        for (int[] line : lines) {
            min = Math.min(min, line[0]);
            max = Math.max(max, line[1]);
        }
        
        for(int i = min; i<max; i++){
            int cnt=0;
            for(int[] line : lines){
                if(line[0]<=i && line[1]>i)cnt++;
                if(cnt==2){
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}
