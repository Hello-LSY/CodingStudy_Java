import java.util.Arrays;

class Solution {
    public int[] solution(int num, int total) {
        int[] answer = new int[num];
        
        int mid = total/num;
        
        int cnt1=0;
        int cnt2=1;
        
        for(int i=num/2; i>=0; i--){
            answer[i]=mid-cnt1;
            cnt1++;
        }
        for(int i=num/2+1; i<num; i++){
            answer[i]=mid+cnt2;
            cnt2++;
        }
        
        if(num%2==0){
            for(int i=0; i<answer.length; i++) answer[i]++;
        }
        
        return answer;
    }
}