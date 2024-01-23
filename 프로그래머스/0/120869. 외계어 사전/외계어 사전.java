class Solution {
    public int solution(String[] spell, String[] dic) {
        int answer = 0;
        int cnt=0;
        for(String d : dic){
            cnt=0;
            for(String s : spell){
                if(d.contains(s))cnt++;
            }
            if(cnt==spell.length)return 1;
        }
        
        return 2;
    }
}