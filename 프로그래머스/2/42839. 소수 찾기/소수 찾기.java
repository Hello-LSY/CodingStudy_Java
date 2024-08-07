import java.util.*;

class Solution {
    public int solution(String numbers) {
        //HashSet : 중복저장안됨
        Set<Integer> primeSet = new HashSet<>();
        char[] chars = numbers.toCharArray();
        boolean[] visited = new boolean[numbers.length()];
        dfs(chars, "", visited, primeSet);
        // 소수 개수 세기
        int answer = 0;
        for (int num : primeSet) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 순열 생성
    private void dfs(char[] nums, String current, boolean[] visited, Set<Integer> primeSet) {
        
        if (!current.equals("")) {
            primeSet.add(Integer.parseInt(current));
        }

        // 순열 생성
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(nums, current + nums[i], visited, primeSet);
                visited[i] = false; // 백트래킹
            }
        }
    }

    // 소수 여부 확인
    private boolean isPrime(int num){
        if(num<2)return false;
        //Math.sqrt 호출이슈 수정
        for(int i = 2; i*i<=num; i++){
            if(num%i==0)return false;
        }
        
        return true;
    }
}