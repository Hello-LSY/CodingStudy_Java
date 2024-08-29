import java.util.*;
class Solution {
    public int solution(String numbers) {
        int answer = 0;
        boolean[] visited = new boolean[numbers.length()];
        Set<Integer> hashSet = new HashSet<>();
        dfs(numbers.toCharArray(), "", visited, hashSet);
        
        for(int i : hashSet){
            if(isPrime(i)) answer++;
        }
        
        return answer;
    }
    
    private void dfs(char[] charArr, String result, boolean[] visited, Set<Integer> hashSet){
        if(!result.equals("")){
            hashSet.add(Integer.parseInt(result));
        }
        
        for(int i=0; i<charArr.length; i++){
            if(!visited[i]){
                visited[i]=true;
                dfs(charArr, result+charArr[i], visited, hashSet);
                visited[i]=false;
            }
        }
    }
    
    private boolean isPrime(int n){
        if(n<2) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0)return false;
        }
        return true;
    }
    
}