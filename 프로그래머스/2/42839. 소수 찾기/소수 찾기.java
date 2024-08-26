import java.util.*;

class Solution {
    public int solution(String numbers) {
        //HashSet : 중복저장안됨
        Set<Integer> primeSet = new HashSet<>();
        boolean[] visited = new boolean[numbers.length()];
        char[] chars = numbers.toCharArray();
        int answer=0;
        dfs(chars, "", visited, primeSet);
        for(int num : primeSet){
            if(isPrime(num)) answer++;
        }

        return answer;
    }

    // 순열 생성
    private void dfs(char[] chars, String cur, boolean[] visited, Set<Integer> primeSet){
        if(!cur.equals("")){
            primeSet.add(Integer.parseInt(cur));
        }
        
        for(int i=0; i<chars.length; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(chars, cur+chars[i], visited, primeSet);
                visited[i] = false;
            }
        }
        
    }

    // 소수 여부 확인
    private boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0)return false;
        }
        return true;
    }
}