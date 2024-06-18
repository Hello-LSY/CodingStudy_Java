class Solution {
    public static int answer = 0;

    public int solution(int n) {
        

        int[] arr = new int[n];
        dfs(arr,0,n);
        
        return answer;
    }
    
    public void dfs(int[] arr, int position, int n){
        if(position==n){
            answer++;
            return;
        } 
        
        for(int i=0; i<n; i++){
            if(isAble(arr, position, i)){
                arr[position] = i;
                dfs(arr, position+1, n);
            }
        }
    }
    
    //가능한지 메서드
    public boolean isAble(int[] arr, int row, int col){
        for(int i=0; i<row; i++){
            //같은열
            if(arr[i]==col ||
            //같은 대각선 
            Math.abs(arr[i] - col) == Math.abs(i - row)
            ) return false;
        } return true;
    }
}