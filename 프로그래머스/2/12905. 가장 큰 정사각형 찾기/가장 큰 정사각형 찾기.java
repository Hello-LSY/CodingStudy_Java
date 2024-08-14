class Solution{
    public int solution(int [][]board){
        
        if(board.length==1 || board[0].length ==1){
            return 1;
        }
        int answer = 0;
        
        for(int i = 1; i < board.length; i++){
            for(int j = 1; j < board[0].length; j++){

                // 메모이제이션 진행
                if(board[i][j] != 0){
                    // 위의 세 값중에 제일 작은 값 + 1
                    board[i][j] = Math.min(board[i-1][j-1], Math.min(board[i-1][j], board[i][j-1])) + 1;
                    // 갱신
                    answer = Math.max(board[i][j], answer);
                }
            }
        }
        
        return answer * answer;
    }
}