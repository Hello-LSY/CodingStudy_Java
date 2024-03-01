import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for (int weight : weights) {
            answer += seesawCul(weight, map);
        }

        return answer;
    }

    public long seesawCul(int w, Map<Double, Integer> map) {
        long answer = 0;
        double[] distances = {1.0, 
                              2.0 / 3.0, 
                              1.0 / 2.0, 
                              3.0 / 4.0};

        for (double distance : distances) {
            double calculatedWeight = w * distance;
            if (map.containsKey(calculatedWeight)) {
                answer += map.get(calculatedWeight);
            }
        }

        map.put(w * 1.0, map.getOrDefault(w * 1.0, 0) + 1);

        return answer;
    }
}
