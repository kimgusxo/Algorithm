class Solution {
    public int solution(int[][] dots) {
        int maxX = Integer.MIN_VALUE;
        int maxY = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
        
        for(int i = 0; i < dots.length; i++) {
            if(dots[i][0] > maxX) maxX = dots[i][0];
            if(dots[i][0] < minX) minX = dots[i][0];
            if(dots[i][1] > maxY) maxY = dots[i][1];
            if(dots[i][1] < minY) minY = dots[i][1];
        }
        return (maxX-minX)*(maxY-minY);
    }
}