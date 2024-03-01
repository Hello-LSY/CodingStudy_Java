class Solution {
    public String solution(String number, int k) {
        
        int nowIdx = 0;
        int tmpIdx=0;
        int length = number.length()-k;
        
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<length; i++){
            int maxNum = 0;

            for(int j=nowIdx; j<=i+k; j++){
                int curNum = number.charAt(j)-'0';
                if(maxNum<curNum){
                    tmpIdx = j;
                    maxNum = curNum;
                }
            }
            nowIdx = tmpIdx+1;
            sb.append(maxNum);
        }
        
        return sb.toString();
    }
}