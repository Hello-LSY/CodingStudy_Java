import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int i = 0; // 가장 가벼운 사람
        int j = people.length - 1; // 가장 무거운 사람
        
        while (i <= j) {
            // 두 사람의 무게 합이 limit을 넘지 않는 경우
            if (people[i] + people[j] <= limit) {
                i++;
            }
            // 가장 무거운 사람을 보트에 태움
            j--;
            answer++;
        }
        
        return answer;
    }
}
