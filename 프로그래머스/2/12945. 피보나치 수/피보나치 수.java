class Solution {
    public int solution(int n) {
        return fib(n);
    }
    
    private int fib(int n){
        int result = 0;
        int fNum = 0;
        int sNum = 1;
        
        for(int i=2; i<=n; i++){
            result = (fNum + sNum) % 1234567;
            fNum = sNum;
            sNum = result;
        }
        
        return result;
    }
}
