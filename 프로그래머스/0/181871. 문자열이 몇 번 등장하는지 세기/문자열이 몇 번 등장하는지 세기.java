class Solution {
    public int solution(String myString, String pat) {
        int answer = 0;
        
        for(int i=0; i<myString.length()-pat.length()+1; i++){
            String s = "";
            for(int j=i; j<i+pat.length(); j++){
                s += myString.charAt(j);
            }
            if(s.equals(pat))answer++;
        }
        
        return answer;
    }
}