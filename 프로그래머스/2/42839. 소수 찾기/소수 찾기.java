import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primeSet = new HashSet<>();
        char[] chars = numbers.toCharArray();
        boolean[] visited = new boolean[numbers.length()];

        generatePermutations(chars, "", visited, primeSet);

        int answer = 0;
        for (int num : primeSet) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    private void generatePermutations(char[] nums, String current, boolean[] visited, Set<Integer> primeSet) {
        if (!current.equals("")) {
            primeSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(nums, current + nums[i], visited, primeSet);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
