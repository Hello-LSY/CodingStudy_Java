import java.util.*;

class Solution {
    public int solution(int[] array) {
        
        int answer = 0;
        int[] idx = new int[1001];
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < array.length; i++) {
            idx[array[i]]++;
        }
        
        for (int j = 0; j < idx.length; j++) {
            if (max < idx[j]) {
                max = idx[j];
                answer = j;
            } else if (max == idx[j]) {
                answer = -1;
            }
        }
        
        return answer;
    }
}
