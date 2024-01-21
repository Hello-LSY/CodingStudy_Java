class Solution {
    public int solution(int[] num_list) {
        int hol = 0;
        int zzak = 0;
        
        for(int i=0; i<num_list.length; i++){
            if(i%2==1)zzak+=num_list[i];
            else hol+=num_list[i];
            
        }
        return hol>zzak ? hol : zzak;
    }
}