class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        double incli1 = (double) Math.abs(dots[0][0]-dots[1][0]) / (double) Math.abs(dots[0][1]-dots[1][1]);
        double incli2 = (double) Math.abs(dots[2][0]-dots[3][0]) / (double) Math.abs(dots[2][1]-dots[3][1]);

        double incli3 = (double) Math.abs(dots[0][0]-dots[2][0]) / (double) Math.abs(dots[0][1]-dots[2][1]);
        double incli4 = (double) Math.abs(dots[1][0]-dots[3][0]) / (double) Math.abs(dots[1][1]-dots[3][1]);

        double incli5 = (double) Math.abs(dots[0][0]-dots[3][0]) / (double) Math.abs(dots[0][1]-dots[3][1]);
        double incli6 = (double) Math.abs(dots[1][0]-dots[2][0]) / (double) Math.abs(dots[1][1]-dots[2][1]);

        
        if(incli1 == incli2 || incli3 == incli4 || incli5 == incli6) {
            answer = 1;
        }
        return answer;
    }
}