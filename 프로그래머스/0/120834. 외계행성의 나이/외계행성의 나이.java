class Solution {
    public String solution(int age) {
        String alpha = String.valueOf(age);
        String answer="";
        for(int i=0; i<alpha.length(); i++){
            answer+= (char)(alpha.charAt(i)+49);
        }
        return answer;
    }
}