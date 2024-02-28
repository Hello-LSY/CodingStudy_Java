class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpet = brown + yellow;
        
        for(int w=3; w<carpet; w++){
            int h= carpet/w;
            
            if(carpet % w ==0 && h>=3){
                int col = Math.max(w,h);
                int row = Math.min(w,h);
                int center = (col-2) * (row-2);
                
                if(center ==yellow){
                    answer[0] = col;
                    answer[1] = row;
                }
            }
        }
        
        return answer;
    }
}