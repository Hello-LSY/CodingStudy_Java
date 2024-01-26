class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        
        for(int start=i; start<=j; start++){
            int[]arr = num_array(start);
            for(int n : arr){
                if(n==k)answer++;
            }
        }
        
        return answer;
    }
    
    public int[] num_array(int n){
        String s = String.valueOf(n);
        int[] arr = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            arr[i]=Character.getNumericValue(s.charAt(i));
        }
        return arr;
    }
}