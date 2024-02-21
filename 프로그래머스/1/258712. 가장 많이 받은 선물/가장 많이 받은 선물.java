import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int cnt = 0;
        int[][] giftTrades = new int[friends.length][friends.length];
        int[] giftScores = new int[friends.length];
        int[] giftResults = new int[friends.length];
        Map<String, Integer> hashMap = new HashMap<>();

        for (String s : friends) {
            hashMap.put(s, cnt++);
        }

        // 선물 교환 표 구하기
        for (String s : gifts) {
            String[] arr = s.split(" ");
            String give = arr[0];
            String take = arr[1];
            giftTrades[hashMap.get(give)][hashMap.get(take)]++;
        }

        // 선물 지수 구하기
        for (int i = 0; i < friends.length; i++) {
            for (int j = 0; j < friends.length; j++) {
                giftScores[i] += giftTrades[i][j];
                giftScores[j] -= giftTrades[i][j];
            }
        }

        // 다음달 선물 예측하기
        for (int i = 0; i < friends.length; i++) {
            for (int j = i + 1; j < friends.length; j++) {
                int humanA = giftTrades[i][j];
                int humanB = giftTrades[j][i];
                int giftscoreA = giftScores[i];
                int giftscoreB = giftScores[j];
                
                
                if (giftscoreA == giftscoreB) {
                    // 두 사람 선물 지수가 같음
                    continue;
                } else if (humanA != humanB) {
                    // 두 사람 교환이력 있을 때
                    if (humanA > humanB) {
                        giftResults[i]++;
                    } else {
                        giftResults[j]++;
                    }
                } else {
                    // 두 사람 교환이력 없거나 같을 때
                    if (giftscoreA > giftscoreB) {
                        giftResults[i]++;
                    } else if (giftscoreA < giftscoreB) {
                        giftResults[j]++;
                    }
                }
            }
        }

        // 최대 선물 수 찾기
        for (int i = 0; i < friends.length; i++) {
            answer = Math.max(answer, giftResults[i]);
        }

        return answer;
    }
}
