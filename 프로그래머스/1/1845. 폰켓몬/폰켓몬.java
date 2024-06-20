import java.util.*;

class Solution {
    public int solution(int[] nums) {        
        HashSet<Integer> ponketPick = new HashSet<>();
        
        for(int ponketNumber : nums){
            ponketPick.add(ponketNumber);
        }
        
        return Math.min(ponketPick.size(), nums.length/2);
    }
}