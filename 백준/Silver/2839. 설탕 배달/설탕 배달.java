import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        
        while (true) {
            if (N % 5 == 0) {
                count += N / 5;
                bw.write(String.valueOf(count));
                break;
            } else {
                N -= 3;
                count++;
            }
            if (N < 0) {
                bw.write(String.valueOf("-1"));
                break;
            }
        }
        
        br.close();
        bw.flush();
        bw.close();
    }
}
