class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] student = new int[n];
        
        for(int i=0; i<lost.length; i++){
            student[lost[i]-1]--;
        }
        for(int i=0; i<reserve.length; i++){
            student[reserve[i]-1]++;
        }
        
        for(int i=0; i<student.length; i++){
            if(student[i]==-1){
                if(i-1>=0 && student[i-1]==1){
                    student[i-1]--;
                    student[i]++;
                } 
                else if(i+1<student.length && student[i+1]==1){
                    student[i+1]--;
                    student[i]++;
                }   
            }
        }
        
        for(int i : student){
            if(i>=0)answer++;
        }
        
        return answer;
    }
}