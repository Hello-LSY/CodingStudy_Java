import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        
        int[] arr = {a, b, c, d};
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i : arr) {
            hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }
        List<Integer>keys = new ArrayList<>(hashMap.keySet());

        // 주사위가 모두 같은 숫자인 경우
        if (hashMap.size() == 1) {
            int p = arr[0];
            return 1111 * p;
        // 주사위가 두가지    
        } else if (hashMap.size() == 2) {
            //둘중하나라도 1이 나온다면 1:3
            if(hashMap.containsValue(1) || hashMap.containsValue(3)){
                int p = hashMap.get(keys.get(0)) == 3 ? keys.get(0) : keys.get(1);
                int q = hashMap.get(keys.get(0)) == 1 ? keys.get(0) : keys.get(1);
                return (int)Math.pow((10*p)+q, 2);
            }
            else {
                int p = keys.get(0);
                int q = keys.get(1);
                return (p + q) * Math.abs(p - q); 
            }
        }
        //주사위가 세가지
        else if (hashMap.size() == 3) {
            int result=0;
            for(int key : keys){
                if(hashMap.get(key)!=2){
                    if(result==0)result=key;
                    else return result * key;
                }
            }

        } else {
            // 주사위가 네가지
            Collections.sort(keys);
            return keys.get(0);
        }
        return 0;

    }
}
