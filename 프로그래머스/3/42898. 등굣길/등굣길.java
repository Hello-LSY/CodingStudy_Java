class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int[][] route = new int[n][m];
        
        for(int[] puddle : puddles){
            int x = puddle[0]-1;
            int y = puddle[1]-1;
            route[y][x] = -1;
        }
        route[0][0]=1;
        for(int i=0; i<route.length; i++){
            for(int j=0; j<route[i].length; j++){
                if(route[i][j]==-1){
                    route[i][j]=0;
                    continue;
                }
                if(i>0){
                    route[i][j]+=route[i-1][j] % 1000000007;
                }
                if(j>0){
                    route[i][j]+=route[i][j-1] % 1000000007;
                }
            }   
        }
        
        answer = route[n-1][m-1] % 1000000007;

        
        return answer;
    }
}