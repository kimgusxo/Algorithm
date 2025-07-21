class Solution {
    public int solution(int[][] lines) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        
        for(int[] line : lines) {
            for(int point : line) {
                min = Math.min(min, point);
                max = Math.max(max, point);
            }
        }
        
        for(int i = min; i <= max; i++) {
            int cnt = 0;
            for(int[] line : lines) {
                if(line[0] <= i && i < line[1]) {
                    cnt++;
                }
            }
            
            if(cnt > 1) answer++;
        }
        
        return answer;
    }
}