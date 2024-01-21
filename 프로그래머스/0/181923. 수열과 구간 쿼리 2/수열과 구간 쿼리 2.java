class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int startIndex = queries[i][0];
            int endIndex = queries[i][1];
            int threshold = queries[i][2];
            int min = Integer.MAX_VALUE;
            boolean found = false;
            
            for (int j = startIndex; j <= endIndex; j++) {
                if (arr[j] > threshold && arr[j] < min) {
                    min = arr[j];
                    found = true;
                }
            }
            
            if (found) {
                answer[i] = min;
            } else {
                answer[i] = -1;
            }
        }
        
        return answer;
    }
}