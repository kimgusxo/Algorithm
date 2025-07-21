class Solution {
    public int solution(int a, int b) {
        for(int i = a; i > 1; i--) {
            if(a%i == 0 && b%i == 0) {
                a /= i;
                b /= i;
            }
        }

        while((b%2 == 0 || b%5 == 0)) {
            if(b%2 == 0) {
                b /= 2;
            }
            if(b%5 == 0) {
                b /= 5;
            }
            if(b == 1) break;
        }

        return b == 1 ? 1 : 2;

    }
}