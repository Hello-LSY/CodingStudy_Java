class Solution {
    public int solution(int chicken) {
        int coupon_cnt = 0;
        int chicken_cnt = 0;
        
        while (chicken > 0 || coupon_cnt >= 10) {
            coupon_cnt += chicken % 10;
            chicken_cnt += chicken / 10;
            chicken /= 10;
            
            while (coupon_cnt >= 10) {
                int service_chicken = coupon_cnt / 10;
                chicken_cnt += service_chicken;
                coupon_cnt = coupon_cnt % 10 + service_chicken;
            }
        }
        
        return chicken_cnt;
    }
}
