import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};

        int[] giveUpMath1 = {1,2,3,4,5};
        int[] giveUpMath2 = {2,1,2,3,2,4,2,5};
        int[] giveUpMath3 = {3,3,1,1,2,2,4,4,5,5};

        int cnt1 = 0;
        int cnt2 = 0;
        int cnt3 = 0;

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == giveUpMath1[i % giveUpMath1.length]) cnt1++;
            if (answers[i] == giveUpMath2[i % giveUpMath2.length]) cnt2++;
            if (answers[i] == giveUpMath3[i % giveUpMath3.length]) cnt3++;
        }

        int maxCnt = Math.max(cnt1, Math.max(cnt2, cnt3));

        List<Integer> resultList = new ArrayList<>();

        if (maxCnt == cnt1) resultList.add(1);
        if (maxCnt == cnt2) resultList.add(2);
        if (maxCnt == cnt3) resultList.add(3);

        answer = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}
