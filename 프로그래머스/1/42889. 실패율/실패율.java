import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        Map<Integer, Double> hashMap = new HashMap<>();
        double fRate=0;
        for (int i = 1; i <= N; i++) {
            int t = 0;
            int f = 0;
            for (int stage : stages) {
                if (stage > i) f++;
                if (stage == i) t++;
            }
            
            if(t==0)fRate=0.0;
            else fRate = (double) t / f;
            
            hashMap.put(i, fRate);
        }

        List<Map.Entry<Integer, Double>> entryList = new ArrayList<>(hashMap.entrySet());
        entryList.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));
        for (int i = 0; i < N; i++) {
            answer[i] = entryList.get(i).getKey();
        }

        return answer;
    }
}
