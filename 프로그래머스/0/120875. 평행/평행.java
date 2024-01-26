class Solution {
    public int solution(int[][] dots) {
        for (int i = 0; i < dots.length - 1; i++) {
            for (int j = i + 1; j < dots.length; j++) {
                double x1 = dots[i][0];
                double y1 = dots[i][1];
                double x2 = dots[j][0];
                double y2 = dots[j][1];


                if (x1 == x2 || y1 == y2) {
                    continue;
                }

                boolean parallel = true;

                for (int k = 0; k < dots.length; k++) {
                    if (k != i && k != j) {
                        double x3 = dots[k][0];
                        double y3 = dots[k][1];
                        double x4 = dots[6-i-j-k][0];
                        double y4 = dots[6-i-j-k][1];

                        if ((y2 - y1) * (x3 - x4) != (y3 - y4) * (x2 - x1)) {
                            parallel = false;
                            break;
                        }
                    }
                }

                if (parallel) {
                    return 1;
                }
            }
        }

        return 0;
    }
}
