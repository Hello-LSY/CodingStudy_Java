import java.util.Arrays;
import java.util.Collections;

class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int x_max = 0;
        int y_max = 0;
        for(int i=0; i<sizes.length; i++){
            int w = Math.max(sizes[i][0], sizes[i][1]);
            int h = Math.min(sizes[i][0], sizes[i][1]);
            x_max = Math.max(x_max, w);
            y_max = Math.max(y_max, h);
        }
        return x_max * y_max;
    }
}