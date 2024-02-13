import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int hIndex = 0;

        for (int i = 0; i < n; i++) {
            int smallerCount = Math.min(citations[i], n - i);
            hIndex = Math.max(hIndex, smallerCount);
        }

        return hIndex;
    }
}
