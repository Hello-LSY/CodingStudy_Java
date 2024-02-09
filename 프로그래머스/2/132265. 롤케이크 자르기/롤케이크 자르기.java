import java.util.*;
class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        
        Map<Integer, Integer> hashMap1 = new HashMap<>();
        Map<Integer, Integer> hashMap2 = new HashMap<>();
        
        for(int i : topping){
            hashMap1.put(i, hashMap1.getOrDefault(i,0)+1);
        }
        
        for(int i : topping){
            hashMap2.put(i, hashMap2.getOrDefault(i,0)+1);
            
            if(hashMap1.get(i)-1 == 0) hashMap1.remove(i);
            else hashMap1.put(i, hashMap1.get(i)-1);
            
            if(hashMap1.size() == hashMap2.size())answer++;   
        }
        
        return answer;
    }
}