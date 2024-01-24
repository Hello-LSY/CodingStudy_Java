class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        
        int[][]bomb = new int[board.length+2][board.length+2];
        int[][] check = {{-1, -1}, {0, -1}, {1, -1}, 
                         {-1, 0}, {0, 0}, {1, 0}, 
                         {-1, 1}, {0, 1}, {1, 1}};
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j]==1){
                    for(int k=0; k<9; k++)
                        bomb[i+check[k][0]+1][j+check[k][1]+1]++;
                }
            }
        }
        

        for(int i=1; i<bomb.length-1; i++){
            for(int j=1; j<bomb[0].length-1; j++){
                if(bomb[i][j]==0)answer++;
            }
        }
        
        
        return answer;
    }
}