import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        List<Integer>list = Arrays.asList(Arrays.stream(num_list).boxed().toArray(Integer[]::new));
        Collections.reverse(list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}