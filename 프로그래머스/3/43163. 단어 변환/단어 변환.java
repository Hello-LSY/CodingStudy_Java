class Solution {
    private static boolean visited[];
    private static int minStep;
        
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        minStep = Integer.MAX_VALUE;
        dfs(begin, target, words, 0);
        
        return minStep == Integer.MAX_VALUE ? 0 : minStep;
    }
    
    private void dfs(String cur, String target, String[] words, int step) {
        if (cur.equals(target)) {
            minStep = Math.min(step, minStep);
            return;
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && cmpStr(cur, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, step + 1);
                visited[i] = false;  
            }
        }
    }
    
    // 한 글자만 다른지 확인
    private boolean cmpStr(String s1, String s2) {
        int cnt = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                cnt++;
            }
        }
        return cnt == 1;
    }
}
