import java.util.ArrayList;

class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        for(int i=0; i<intStrs.length; i++){
            if(Integer.parseInt(intStrs[i].substring(s, s+l))>k)
            answer.add(Integer.parseInt(intStrs[i].substring(s, s+l)));
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}