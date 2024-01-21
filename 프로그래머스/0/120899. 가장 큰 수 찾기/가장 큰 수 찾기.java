import java.util.Arrays;

class Solution {
    public int[] solution(int[] array) {
        
        int max = Arrays.stream(array).max().getAsInt();
        int maxIndex = Arrays.binarySearch(array, max);
        int[] answer = {max,maxIndex};
        
        return answer;
    }
}