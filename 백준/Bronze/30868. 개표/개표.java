import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            while(n>0){
                if(n>=5){
                    System.out.print("++++ ");
                    n-=5;
                }else{
                    System.out.print("|");
                    n-=1;
                }
            }
            System.out.println();
        }
    }
}