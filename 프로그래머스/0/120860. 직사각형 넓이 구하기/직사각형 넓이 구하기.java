class Solution {
    public int solution(int[][] dots) {
        int x1 = dots[0][0];
        int x2 = dots[0][0];
        int y1 = dots[0][1];
        int y2 = dots[0][1];
        for (int i = 1; i < dots.length; i++) {
            x1= Math.max(x1, dots[i][0]);
            x2= Math.min(x2, dots[i][0]);
            y1= Math.max(y1, dots[i][1]);
            y2= Math.min(y2, dots[i][1]);
        }
        return (x1-x2) * (y1-y2);
    }
}