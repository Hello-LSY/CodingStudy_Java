class Solution {
    public String solution(String my_string, int s, int e) {
        StringBuilder answer = new StringBuilder(my_string);

        String reversedSubs = answer.substring(s, e + 1);
        answer.replace(s, e + 1, new StringBuilder(reversedSubs).reverse().toString());

        return answer.toString();
    }
}
