class Solution {
    public int solution(String begin, String target, String[] words) {
        
        int answer = dfs(begin, target, words, new boolean[words.length], 0, Integer.MAX_VALUE);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    
    private int dfs(String current, String target, String[] words, boolean[] visited, int steps, int minSteps) {
        
        if (current.equals(target)) {
            return Math.min(minSteps, steps);
        }

        // 다음 단어 탐색
        for (int i = 0; i < words.length; i++) {
            // 방문하지 않았고, 현재 단어와 다른 단어 중 한 문자만 다른 경우
            if (!visited[i] && isOneCharDifferent(current, words[i])) {
                visited[i] = true; // 방문 표시
                minSteps = dfs(words[i], target, words, visited, steps + 1, minSteps); // DFS 호출
                visited[i] = false; // 백트래킹
            }
        }

        return minSteps;
    }

    // 두 단어가 한 문자만 다른지 여부 확인
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
