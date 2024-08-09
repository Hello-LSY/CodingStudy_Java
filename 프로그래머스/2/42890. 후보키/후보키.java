import java.util.*;

class Solution {

    public int solution(String[][] relation) {
        int n = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();

        for (int i = 1; i < (1 << n); i++) {
            if (isUnique(i, relation) && isMinimal(i, candidateKeys)) {
                candidateKeys.add(i);
            }
        }

        return candidateKeys.size();
    }

    // 유일성 검사
    private boolean isUnique(int subset, String[][] relation) {
        Set<String> seen = new HashSet<>();
        
        for (String[] row : relation) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < relation[0].length; j++) {
                if ((subset & (1 << j)) != 0) {
                    sb.append(row[j]).append(",");
                }
            }
            if (!seen.add(sb.toString())) {
                return false;
            }
        }
        return true;
    }

    // 최소성 검사
    private boolean isMinimal(int subset, List<Integer> candidateKeys) {
        for (int key : candidateKeys) {
            if ((subset & key) == key) {
                return false;
            }
        }
        return true;
    }
}
