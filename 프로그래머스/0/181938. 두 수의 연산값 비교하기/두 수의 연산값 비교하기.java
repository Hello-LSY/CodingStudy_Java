import java.lang.Math;
class Solution {
    public int solution(int a, int b) {
        int result_1 = Integer.parseInt(Integer.toString(a) + Integer.toString(b));
        int result_2 = 2 * a * b;
        
        return Math.max(result_1,result_2);
    }
}