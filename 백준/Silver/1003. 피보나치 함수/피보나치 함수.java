import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            int[] fib_0 = new int[41];
            int[] fib_1 = new int[41];
            fib_0[0] = 1;
            fib_0[1] = 0;
            fib_1[0] = 0;
            fib_1[1] = 1;
            for(int k=2; k<=n; k++){
                fib_0[k] = fib_0[k-1] + fib_0[k-2];
                fib_1[k] = fib_1[k-1] + fib_1[k-2];
            }
            sb.append(fib_0[n]).append(" ").append(fib_1[n]).append("\n");
        }
        System.out.print(sb);
    }


}
