class Solution {
    public int solution(int[] num_list) {
        int cnt=0;
        for(int i=0; i<num_list.length; i++){
            
            if(num_list[i]>0)cnt++;
            else return cnt;
        }
        return -1;
    }
}