class Solution {
    public int solution(int n) {
        int pizza = 7;
        while(n>pizza){
            pizza+=7;
        }
        return pizza/7;
    }
}