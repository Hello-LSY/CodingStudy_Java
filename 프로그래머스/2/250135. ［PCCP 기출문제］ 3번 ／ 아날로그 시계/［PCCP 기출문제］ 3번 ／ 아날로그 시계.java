import java.util.*;

class Solution {
    static class Time {
        int h, m, s;

        Time(int h, int m, int s) {
            this.h = h;
            this.m = m;
            this.s = s;
        }

        Time(int seconds) {
            this.h = seconds / 3600;
            this.m = (seconds % 3600) / 60;
            this.s = seconds % 60;
        }

        int toSeconds() {
            return h * 3600 + m * 60 + s;
        }

        double getHourDegree() {
            return (h % 12) * 30 + m * 0.5 + s * (1 / 120.0);
        }

        double getMinuteDegree() {
            return m * 6 + s * 0.1;
        }

        double getSecondDegree() {
            return s * 6;
        }
    }

    public int solution(int h1, int m1, int s1, int h2, int m2, int s2) {
        int count = 0;

        int start = new Time(h1, m1, s1).toSeconds();
        int end = new Time(h2, m2, s2).toSeconds();

        for (int i = start; i < end; i++) {
            Time currentTime = new Time(i);
            Time nextTime = new Time(i + 1);

            double currentSecondAngle = currentTime.getSecondDegree();
            double currentMinuteAngle = currentTime.getMinuteDegree();
            double currentHourAngle = currentTime.getHourDegree();

            double nextSecondAngle = nextTime.getSecondDegree();
            double nextMinuteAngle = nextTime.getMinuteDegree();
            double nextHourAngle = nextTime.getHourDegree();

            boolean hourMatch = hasPassed(currentHourAngle, currentSecondAngle, nextHourAngle, nextSecondAngle);
            boolean minuteMatch = hasPassed(currentMinuteAngle, currentSecondAngle, nextMinuteAngle, nextSecondAngle);

            if (hourMatch && minuteMatch) {
                if (Double.compare(nextHourAngle, nextMinuteAngle) == 0) count++;
                else count += 2;
            } else if (hourMatch || minuteMatch) {
                count++;
            }
        }

        if (start == 0 || start == 43200) count++;
        return count;
    }

    boolean hasPassed(double hand1Start, double hand2Start, double hand1End, double hand2End) {
        return hand1Start > hand2Start && hand1End <= hand2End || 
               hand2Start == 354 && hand1Start > 354;
    }
}
