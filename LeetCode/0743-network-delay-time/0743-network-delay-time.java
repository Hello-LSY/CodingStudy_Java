import java.util.*;

class Solution {

    public int networkDelayTime(int[][] times, int n, int k) {
        // 인접 리스트로 그래프 표현
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] time : times) {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        // 거리 배열 초기화
        int[] disQue = new int[n + 1];
        Arrays.fill(disQue, Integer.MAX_VALUE);
        disQue[k] = 0;

        // 우선순위 큐 초기화 (거리 기준으로 정렬)
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{k, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int node = current[0];
            int currentDistance = current[1];

            if (currentDistance > disQue[node]) {
                continue;
            }

            // 현재 노드와 연결된 모든 노드에 대해 거리 업데이트
            for (int[] edge : graph.get(node)) {
                int nextNode = edge[0];
                int travelTime = edge[1];
                int newDistance = currentDistance + travelTime;

                if (newDistance < disQue[nextNode]) {
                    disQue[nextNode] = newDistance;
                    pq.offer(new int[]{nextNode, newDistance});
                }
            }
        }

        int maxDistance = Arrays.stream(disQue).skip(1).max().getAsInt();
        return maxDistance == Integer.MAX_VALUE ? -1 : maxDistance;
    }
}
