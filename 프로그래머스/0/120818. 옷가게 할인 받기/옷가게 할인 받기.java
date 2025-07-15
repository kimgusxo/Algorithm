class Solution {
    public int solution(int price) {
        return price >= 500_000 ? (int) Math.floor(price*0.8) :
        price >= 300_000 ? (int) Math.floor(price*0.9) :
        price >= 100_000 ? (int) Math.floor(price*0.95) :
        price;
    }
}