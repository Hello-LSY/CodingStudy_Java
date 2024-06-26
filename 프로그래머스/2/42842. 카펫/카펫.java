class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int carpet = brown + yellow;
        //일단 col, row를 구하면 (col-2) * (row-2) 으로 yellow구역 구할 수 있다 
        //조건으로 주어진건 카펫의 row길이>=col길이
        
        int w = 3;
        while(w<carpet){
            int col = w;
            int row = carpet/w;
            if((col-2)*(row-2)==yellow && row>=col){
                answer[0] = row;
                answer[1] = col;
                break;
            }else{
                w++;
            }
        }
        
        return answer;
    }
}