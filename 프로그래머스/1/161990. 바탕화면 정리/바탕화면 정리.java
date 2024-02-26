class Solution {
    public int[] solution(String[] wallpaper) {
        
        int maxCol = 0;
        int maxRow = 0;
        int minCol = Integer.MAX_VALUE;
        int minRow = Integer.MAX_VALUE;
        
        for(int i=0; i<wallpaper.length; i++){
            for(int j=0; j<wallpaper[i].length(); j++){
                if(wallpaper[i].charAt(j)=='#'){
                    maxCol = Math.max(maxCol, j);
                    minCol = Math.min(minCol, j);
                    maxRow = Math.max(maxRow, i);
                    minRow = Math.min(minRow, i);
                }
            }
        }
        
        
        return new int[]{minRow, minCol, maxRow + 1, maxCol + 1};
    }
}