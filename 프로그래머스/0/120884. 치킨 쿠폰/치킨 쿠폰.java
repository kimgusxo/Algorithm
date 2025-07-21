class Solution {
    public int solution(int chicken) {
        int original = chicken;
        int coupon = chicken;
        while(coupon/10 > 0) {
            int service = coupon/10;
            chicken += service;
            coupon -= service*10;
            coupon += service;
        }
        return chicken-original;
    }
}