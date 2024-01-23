import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        
        Map<Integer, Integer>hashMap = new HashMap<>();
        
        for(int i=0; i<rank.length; i++){
            if(attendance[i]==true)hashMap.put(rank[i], i);
        }
        
        List<Integer>keySet = new ArrayList<>(hashMap.keySet());
        Collections.sort(keySet);
        
        int a = hashMap.get(keySet.get(0));
        int b = hashMap.get(keySet.get(1));
        int c = hashMap.get(keySet.get(2));
        
        return 10000*a + 100*b + c;
    }
}