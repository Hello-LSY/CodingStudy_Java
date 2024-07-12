import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 테스트 케이스의 개수 T를 입력 받습니다.
        int T = sc.nextInt();
        
        for (int test_case = 1; test_case <= T; test_case++) {
            // 10개의 수를 입력받고 그 중 가장 큰 수를 찾습니다.
            int maxNum = 0;
            for (int i = 0; i < 10; i++) {
                int num = sc.nextInt();
                if (num > maxNum) {
                    maxNum = num;
                }
            }
            
            // 출력 형식에 맞게 결과를 출력합니다.
            System.out.println("#" + test_case + " " + maxNum);
        }
        
        sc.close();
    }
}
