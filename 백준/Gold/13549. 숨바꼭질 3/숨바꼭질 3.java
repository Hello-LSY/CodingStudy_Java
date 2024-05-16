import java.io.*;
import java.util.*;

public class Main {
    static int N; 
    static int K;
    static final int MAX_POSITION = 100000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bw.write(dijkstra() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static int dijkstra() {
        int[] distance = new int[MAX_POSITION + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{N, 0});
        distance[N] = 0;

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int currentPosition = current[0];
            int currentDistance = current[1];

            if (currentPosition == K) {
                return currentDistance;
            }

            if (currentDistance > distance[currentPosition]) {
                continue;
            }

            int[] nextPositions = {currentPosition - 1, currentPosition + 1, currentPosition * 2};
            for (int nextPos : nextPositions) {
                if (nextPos >= 0 && nextPos <= MAX_POSITION) {
                    int nextDistance = currentDistance + (nextPos == currentPosition * 2 ? 0 : 1);
                    if (nextDistance < distance[nextPos]) {
                        distance[nextPos] = nextDistance;
                        pq.offer(new int[]{nextPos, nextDistance});
                    }
                }
            }
        }
        return -1; 
    }
}
