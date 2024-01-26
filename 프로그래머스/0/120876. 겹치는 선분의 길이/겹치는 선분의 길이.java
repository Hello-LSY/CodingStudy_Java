class Solution {
    public int solution(int[][] lines) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < lines.length; i++) {
            min = Math.min(min, lines[i][0]);
            max = Math.max(max, lines[i][1]);
        }

        int answer = 0;

        for (int i = min; i <= max; i++) {
            int count = 0;

            for (int j = 0; j < lines.length; j++) {
                if (lines[j][0] <= i && lines[j][1] > i) {
                    count++;
                    if (count >= 2) {
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
