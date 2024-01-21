import java.util.Arrays;

class Solution {
    public int solution(int[] arr) {
        int[] answer = {};
        int cnt=0;        
        while(!Arrays.equals(answer, arr)){
            answer = Arrays.copyOf(arr, arr.length);
            for(int i=0; i<arr.length; i++){
                if(arr[i]>50 && arr[i]%2==0)arr[i]/=2;
                else if(arr[i]<50 && arr[i]%2==1)arr[i]= (arr[i]*2)+1;
            }
            cnt++;
        }
        return cnt-1;
    }
}