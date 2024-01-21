class Solution {
    public int solution(int slice, int n) {
        int pizza=slice;
        
        while(n>pizza){
            pizza+=slice;
        }   
        
        return pizza/slice;
    }
}