class Solution {
    public int solution(String s) {
        int answer = s.length(); 
        
        // 1개 단위부터 문자열 길이의 절반까지 반복
        for(int i = 1; i <= s.length() / 2; i++) {
            String curStr = s.substring(0, i);
            int cnt = 1;
            StringBuilder resultStr = new StringBuilder();
            
            // i 단위로 문자열 탐색
            for(int next = i; next <= s.length(); next += i) {
                String nextStr;
                
                if (next + i <= s.length()) {
                    nextStr = s.substring(next, next + i);
                // 마지막 부분 처리
                } else {
                    nextStr = s.substring(next);
                }
                
                // 일치할 때
                if (curStr.equals(nextStr)) {
                    cnt++;
                // 일치하지 않을때 resultStr 갱신
                } else {
                    if (cnt > 1) {
                        resultStr.append(cnt).append(curStr);
                    } else {
                        resultStr.append(curStr);
                    }
                    curStr = nextStr;
                    cnt = 1;
                }
            }
            
            // 마지막 부분 추가
            if (cnt > 1) {
                resultStr.append(cnt).append(curStr);
            } else {
                resultStr.append(curStr);
            }
            
            // 최소값 갱신
            answer = Math.min(answer, resultStr.length());
        }
        
        return answer;
    }
}
