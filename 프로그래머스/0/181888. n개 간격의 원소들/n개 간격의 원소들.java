class Solution {
    public int[] solution(int[] num_list, int n) {
        int i=0;
        int len=0;
        while(i < num_list.length){
            i+=n;
            len++;
        }
        int[] result = new int[len];

        for(int j=0, k=0; j<len; j++){
            result[j] = num_list[k];
            k+=n;
        }
        
        return result;
    }
}