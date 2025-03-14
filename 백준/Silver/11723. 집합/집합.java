import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String commend = st.nextToken();
            int input = 0;
            switch (commend){
                case "add":
                    set.add(Integer.parseInt(st.nextToken()));
                    break;
                case "remove":
                    set.remove(Integer.parseInt(st.nextToken()));
                    break;
                case "check":
                    input = Integer.parseInt(st.nextToken());
                    if(set.contains(input)){
                        sb.append("1\n");
                    }else{
                        sb.append("0\n");
                    }
                    break;
                case "toggle":
                    input = Integer.parseInt(st.nextToken());
                    if(set.contains(input)){
                        set.remove(input);
                    }else{
                        set.add(input);
                    }
                    break;
                case "all":
                    for(int idx=1; idx<=20; idx++){
                        set.add(idx);
                    }
                    break;
                case "empty":
                    set.clear();
                    break;
            }
        }

        System.out.print(sb.toString());

    }
}
