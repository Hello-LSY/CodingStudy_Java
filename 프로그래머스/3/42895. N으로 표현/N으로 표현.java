import java.util.*;

class Solution {
    //중복방지
    Set<Integer>[] set = new HashSet[9];
    
    public int solution(int N, int number) {
        int answer = 0;
        int num = 0;
        
        for(int i=1; i<=8; i++){
            num = num*10 + N;
            set[i] = new HashSet<>();
            set[i].add(num);
        }
        
        if(N==number) return 1;
        
        //8까지 찾기
        for(int i=2; i<=8; i++){
            for(int j=1; j<i; j++){
                for(Integer a : set[j]){
                    for(Integer b: set[i-j]){
                        set[i].add(a+b);
                        set[i].add(a-b);
                        set[i].add(a*b);
                        if(b!=0) set[i].add(a/b);
                        if(a!=0) set[i].add(b/a);
                    }
                }
            }
            
            if(set[i].contains(number)){
                answer = i;
                return answer;
            }
        }
        return -1;
    }
}