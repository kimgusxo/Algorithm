class Solution {
    public int solution(int a, int b, int c) {
        int p1 = a + b + c;
        int p2 = p1 * ((int) Math.pow(a, 2) + (int) Math.pow(b, 2) + (int) Math.pow(c, 2));
        int p3 = p2 * ((int) Math.pow(a, 3) + (int) Math.pow(b, 3) + (int) Math.pow(c, 3));
        
        if(a == b && b == c) {
            return p3;
        } else if(a != b && a != c && b != c) {
            return p1;
        } else {
            return p2;
        }
    }
}