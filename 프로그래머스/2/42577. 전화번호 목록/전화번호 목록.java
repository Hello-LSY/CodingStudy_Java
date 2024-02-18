import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
                
        Arrays.sort(phone_book);
        Map<String, Integer> pnMap = new HashMap<>();
        for(String phone_number : phone_book){
            pnMap.put(phone_number, phone_number.length());
        }
        
        for(String phone_number : phone_book){
            for(int i=1; i<phone_number.length(); i++){
                if(pnMap.containsKey(phone_number.substring(0, i)))
                    return false;
            }
        }
        
        return true;
    }
}