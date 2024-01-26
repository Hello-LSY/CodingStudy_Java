class Solution {
    public int solution(String before, String after) {

        char[] b_arr = before.toCharArray();
        
        for(int i=0; i<b_arr.length; i++){
            after=after.replaceFirst(String.valueOf(b_arr[i]), "");
        }
        
        if(after.length()==0)return 1;
        else return 0;
    }
}