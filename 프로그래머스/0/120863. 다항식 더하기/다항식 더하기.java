class Solution {
    public String solution(String polynomial) {
        String answer = "";
        int x_cnt = 0;
        int n_cnt = 0;
        
        String[] str = polynomial.split("\\s*\\+\\s*");
        
        for (String s : str) {
            if (s.contains("x")) {
                if (s.length() == 1 || s.equals("x")) {
                    x_cnt++;
                } else {
                    s = s.replace("x", "");
                    x_cnt += Integer.parseInt(s);
                }
            } else {
                n_cnt += Integer.parseInt(s);
            }
        }
        
        if (x_cnt == 0) {
            answer = n_cnt + "";
        } else {
            answer = (x_cnt == 1) ? "x" : x_cnt + "x";
            if (n_cnt != 0) {
                answer += " + " + n_cnt;
            }
        }

        return answer;
    }
}
