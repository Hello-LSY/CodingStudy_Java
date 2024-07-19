import java.util.*;

class Solution {
    static String end = "";
    static int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        end = target;
        boolean[] visited = new boolean[words.length];
        bfs(begin, words, visited);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    public static void bfs(String begin, String[] words, boolean[] visited) {
        Queue<WordNode> q = new LinkedList<>();
        q.add(new WordNode(begin, 0));

        while (!q.isEmpty()) {
            WordNode currentNode = q.poll();
            String curr = currentNode.word;
            int currentCnt = currentNode.count;

            if (curr.equals(end)) {
                answer = Math.min(answer, currentCnt);
                continue;
            }

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && canConvert(curr, words[i])) {
                    visited[i] = true;
                    q.add(new WordNode(words[i], currentCnt + 1));
                }
            }
        }
    }

    public static boolean canConvert(String str1, String str2) {
        int charCnt = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                charCnt++;
            }
        }
        return charCnt == 1;
    }

    static class WordNode {
        String word;
        int count;

        WordNode(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}
