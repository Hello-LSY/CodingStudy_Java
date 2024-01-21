class Solution {
    public int solution(String myString, String pat) {
        String convertString = myString.replace("A", "X").replace("B", "A").replace("X", "B");
        
        return convertString.contains(pat) ? 1 : 0;
    }
}
