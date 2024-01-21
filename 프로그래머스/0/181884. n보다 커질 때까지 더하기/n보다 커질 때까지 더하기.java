class Solution {
    public int solution(int[] numbers, int n) {
        int result=0;
        for(int i=0; i<numbers.length; i++){
            if(result>n) return result;
            result += numbers[i];
        }
        return result;
    }
}