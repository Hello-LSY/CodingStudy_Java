import java.lang.Math;
import java.util.*;
class Solution {
    public int solution(int a, int b, int c) {
        int answer = 0;
        int[]arr = new int [7];
        
        arr[a]++; 
        arr[b]++;
        arr[c]++;
           
        if(arr[a]==3 || arr[b]==3 || arr[c]==3)
            answer= (int)((a+b+c) * (Math.pow(a,2)+Math.pow(b,2)+(Math.pow(c,2))) * (Math.pow(a,3)+Math.pow(b,3)+Math.pow(c,3)));
        else if(arr[a]==2 || arr[b]==2 || arr[c]==2)
            answer= (int)((a+b+c) * (Math.pow(a,2) + Math.pow(b,2) + Math.pow(c,2)));
        else answer= a+b+c;
        
        return answer;
    }
}