import java.util.*;

class Solution {

    public int solution(String[][] relation) {
        int n = relation[0].length; 
        List<List<Integer>> candidates = new ArrayList<>();
        
        // 컬럼 조합 생성
        CombinationGenerator combGen = new CombinationGenerator();
        for (int i = 1; i <= n; i++) {
            candidates.addAll(combGen.combine(n, i));
        }
        
        List<List<Integer>> uniqueKeys = getUniqueKeys(candidates, relation);
        
        List<List<Integer>> resultKeys = getMinimalKeys(uniqueKeys);
        
        return resultKeys.size();
    }
    
    //유일성 검사
    private List<List<Integer>> getUniqueKeys(List<List<Integer>> candidates, String[][] relation) {
        List<List<Integer>> uniqueKeys = new ArrayList<>();
        
        for (List<Integer> candidate : candidates) {
            //중복없애기
            Set<String> set = new HashSet<>();
            for (String[] row : relation) {
                StringBuilder sb = new StringBuilder();
                for (int col : candidate) {
                    sb.append(row[col - 1]).append(",");
                }
                set.add(sb.toString());
            }
            if (set.size() == relation.length) {
                uniqueKeys.add(candidate);
            }
        }
        
        return uniqueKeys;
    }
    
    //최소성 검사
    private List<List<Integer>> getMinimalKeys(List<List<Integer>> uniqueKeys) {
        List<List<Integer>> resultKeys = new ArrayList<>();
        
        for (List<Integer> key : uniqueKeys) {
            boolean isMinimal = true;
            for (List<Integer> resultKey : resultKeys) {
                if (key.containsAll(resultKey)) {
                    isMinimal = false;
                    break;
                }
            }
            if (isMinimal) {
                resultKeys.add(key);
            }
        }
        
        return resultKeys;
    }
    
    // 조합 생성
    class CombinationGenerator {
        private List<List<Integer>> comb;
        
        public List<List<Integer>> combine(int n, int k) {
            comb = new ArrayList<>();
            List<Integer> curComb = new ArrayList<>();
            dfs(n, k, 1, curComb);
            return comb;
        }
        
        private void dfs(int n, int k, int start, List<Integer> curComb) {
            if (curComb.size() == k) {
                comb.add(new ArrayList<>(curComb));
                return;
            }

            for (int i = start; i <= n; i++) {
                curComb.add(i);
                dfs(n, k, i + 1, curComb);
                curComb.remove(curComb.size() - 1);
            }
        }
    }
}
