import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int remainDays = (int) Math.ceil((double) (100 - progresses[i]) / speeds[i]);
            queue.offer(remainDays);
        }

        int cnt = 1;
        int before = queue.poll();

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (before >= current) {
                cnt++;
            } else {
                list.add(cnt);
                cnt = 1;
                before = current;
            }
        }
        list.add(cnt);

        return list.stream().mapToInt(i -> i).toArray();
    }
}
