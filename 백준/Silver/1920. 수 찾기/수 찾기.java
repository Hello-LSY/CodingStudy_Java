import java.util.*;
import java.io.*;

public class Main{

    public static int[] arr;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i=0; i<arr.length; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        
        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine(), " ");
        while(M>0){
            int target = Integer.parseInt(st.nextToken());
            sb.append(binarySearch(target, 0, N-1)).append("\n");
            M--;
        }
        System.out.println(sb);        
    }
    
    public static int binarySearch(int target, int start, int end){
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]==target) return 1;
            else if (arr[mid]>target){
                end = mid-1;
            }else{
                start = mid+1;
            }
        }
        return 0;
    }
    
}