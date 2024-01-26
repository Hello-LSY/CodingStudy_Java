class Solution {
    public int solution(int[] common) {
        int answer=0;
        //등차
        if(common[1]-common[0]==common[2]-common[1]){
            int d= common[1] - common[0];
            answer = common[0] + (common.length)*d;
        }
        //등비
        else{
            int r = common[1]/common[0];
            answer = common[0] * (int)Math.pow(r, common.length);
        }
        return answer;
    }
}