import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] giveUpMath1 = {1,2,3,4,5};
        int[] giveUpMath2 = {2,1,2,3,2,4,2,5};
        int[] giveUpMath3 = {3,3,1,1,2,2,4,4,5,5};

        int cnt1=0;
        int cnt2=0;
        int cnt3=0;
        
        for(int i=0; i<answers.length; i++){
            if(giveUpMath1[i%giveUpMath1.length]==answers[i]) cnt1++;
            if(giveUpMath2[i%giveUpMath2.length]==answers[i]) cnt2++;
            if(giveUpMath3[i%giveUpMath3.length]==answers[i]) cnt3++;
        }
        
        List<Integer> list = new ArrayList<>();
        list.add(cnt1);
        list.add(cnt2);
        list.add(cnt3);
        
        int highScore = Math.max(Math.max(cnt1, cnt2), cnt3);
        List<Integer> result = new ArrayList<>();
        
        for(int i=0; i<3; i++){
            if(list.get(i) == highScore) {
                result.add(i+1); 
            }
        }
        
        return result.stream().mapToInt(i->i).toArray();
    }
}
