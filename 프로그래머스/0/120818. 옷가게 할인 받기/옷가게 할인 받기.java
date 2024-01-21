class Solution {
    public int solution(int price) {
        int discount = 0;
        
        if(price>=100000 && price<300000){
            discount = 5;
        } else if(price>=300000 && price<500000){
            discount = 10;
        }else if(price>=500000){
            discount = 20;
        }else discount = 0;
        
        return price* (100-discount)/100;
    }
}