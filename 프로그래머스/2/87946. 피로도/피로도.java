class Solution {
    static boolean[] visited;
    static int answer;
    
    public int solution(int k, int[][] dungeons) {
        answer = 0;
        visited = new boolean[dungeons.length];
        
        dfs(k, dungeons, 0);
        
        return answer;
    }
    
    public void dfs(int k, int[][] dungeons, int cnt){
        answer = Math.max(answer, cnt);
        
        for(int i = 0; i < dungeons.length; i++){
            int min = dungeons[i][0];
            int req = dungeons[i][1];
            
            if(!visited[i] && k >= min){
                visited[i] = true;
                dfs(k - req, dungeons, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
