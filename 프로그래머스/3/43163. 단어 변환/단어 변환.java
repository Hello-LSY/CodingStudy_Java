import java.util.*;

class Solution {
    private static boolean[] visited;
    private int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        bfs(begin, target, words);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void bfs(String begin, String target, String[] words) {
        Queue<Word> que = new LinkedList<>();
        que.add(new Word(begin, 0));

        while (!que.isEmpty()) {
            Word curNode = que.poll();
            String curWord = curNode.word;
            int curCnt = curNode.count;

            if (curWord.equals(target)) {
                answer = Math.min(answer, curCnt);
                continue;
            }

            for (int i = 0; i < words.length; i++) {
		            //방문안된곳에서 한문자 뺴고 맞나 안맞나 확인
                if (!visited[i] && isValid(curWord, words[i])) {
                    visited[i] = true;
                    //된다면 다음으로 갱신하기위해 word와 cnt 증가
                    que.add(new Word(words[i], curCnt + 1));
                }
            }
        }
    }

    private boolean isValid(String w1, String w2) {
        int diffCnt = 0;
        for (int i = 0; i < w1.length(); i++) {
            if (w1.charAt(i) != w2.charAt(i)) {
                diffCnt++;
            }
        }
        return diffCnt == 1;
    }

    private static class Word {
        String word;
        int count;

        Word(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
}