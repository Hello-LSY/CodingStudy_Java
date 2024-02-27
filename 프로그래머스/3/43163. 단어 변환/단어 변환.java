class Solution {
    public int solution(String begin, String target, String[] words) {
        int answer = dfs(begin, target, words, new boolean[words.length], 0, Integer.MAX_VALUE);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    
    private int dfs(String current, String target, String[] words, boolean[] visited, int steps, int minSteps) {
        if (current.equals(target)) {
            return Math.min(minSteps, steps);
        }
        
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && isOneCharDifferent(current, words[i])) {
                visited[i] = true;
                minSteps = dfs(words[i], target, words, visited, steps + 1, minSteps);
                visited[i] = false;
            }
        }
        
        return minSteps;
    }
    
    private boolean isOneCharDifferent(String s1, String s2) {
        int diffCount = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                diffCount++;
                if (diffCount > 1) {
                    return false;
                }
            }
        }
        return diffCount == 1;
    }
}
