class Solution {
    public int solution(int[][] sizes) {
        int maxW = 0;
        int maxH = 0;
        
        for(int[] size: sizes){
            int w = size[0];
            int h = size[1];
            
            maxW = Math.max(maxW, Math.max(w, h));
            maxH = Math.max(maxH, Math.min(w, h));
        }
        
        return maxW * maxH;
    }
}