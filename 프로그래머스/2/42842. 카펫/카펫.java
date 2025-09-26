class Solution {
    public int[] solution(int brown, int yellow) {
        int size = brown+yellow;
        
        int width = 0;
        int height = 0;
        
        for(int i = 1; i <= Math.sqrt(size); i++) {
            if(size%i == 0) {
                if((size/i-2) * (i-2) == yellow) {
                    width = size/i;
                    height = i;
                }
            }
        }
        
        return new int[]{width, height};
    }
}