import java.util.Arrays;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length-1;
        
        while(left<=right){
            //두 사람 가능
            if(people[left]+people[right] <= limit){
                left++;
                right--;
            //한 사람만 가능
            }else{
                right--;                
            }
                answer++;
        }
        
        return answer;
    }
}