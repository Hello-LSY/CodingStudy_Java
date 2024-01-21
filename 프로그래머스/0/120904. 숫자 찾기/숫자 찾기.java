class Solution {
    public int solution(int num, int k) {
        String numStr = Integer.toString(num);
        int answer = -1;

        for (int i = 0; i < numStr.length(); i++) {
            if (numStr.charAt(i) ==  k + '0') {
                answer = i + 1; 
                break;
            }
        }

        return answer;
    }
}
