class Solution {
    public int solution(int hp) {
        int n1 = hp/5;
        int k1 = hp%5;
        int n2 = k1/3;
        int k2 = k1%3;
        int n3 = k2/1;
        return n1+n2+n3;
    }
}