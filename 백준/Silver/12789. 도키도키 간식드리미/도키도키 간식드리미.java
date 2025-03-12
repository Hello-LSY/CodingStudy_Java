import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Integer> stk = new Stack<>();
        int cnt = 1; // 현재 받을 번호

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());

            // 현재 받을 번호와 같다면 즉시 통과
            if (num == cnt) {
                cnt++;
            } else {
                stk.push(num);
            }

            // 스택의 맨 위 값이 현재 받을 번호라면 계속 통과시킴
            while (!stk.isEmpty() && stk.peek() == cnt) {
                stk.pop();
                cnt++;
            }
        }

        System.out.println(stk.isEmpty() ? "Nice" : "Sad");
    }
}
