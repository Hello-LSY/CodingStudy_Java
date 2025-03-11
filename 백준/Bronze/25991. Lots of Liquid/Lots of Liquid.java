import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double result = 0;
        for(int i=0; i<n; i++){
            double c = Double.parseDouble(st.nextToken());
            result += Math.pow(c, 3);
        }
        System.out.printf("%.6f", Math.cbrt(result));
    }
}