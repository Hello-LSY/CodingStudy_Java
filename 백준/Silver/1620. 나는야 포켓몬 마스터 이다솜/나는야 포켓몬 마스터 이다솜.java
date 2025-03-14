import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<Integer, String> pokeName = new HashMap<>();
        HashMap<String, Integer> pokeNum = new HashMap<>();
        for(int i=1; i<=n; i++){
            String input = br.readLine();
            pokeName.put(i, input);
            pokeNum.put(input, i);
        }

        for(int i=0; i<m; i++){
            String input = br.readLine();
            // 숫자
            if(Character.isDigit(input.charAt(0))){
                sb.append(pokeName.get(Integer.parseInt(input))).append("\n");
            }else{
                sb.append(pokeNum.get(input)).append("\n");
            }
        }
        System.out.print(sb);
    }
}
