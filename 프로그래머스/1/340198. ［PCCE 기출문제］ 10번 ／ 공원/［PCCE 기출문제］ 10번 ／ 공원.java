class Solution {
    public int solution(int[] mats, String[][] park) {
        int range = 0;
        
        int[][] map = new int[park.length][park[0].length];
        
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[0].length; j++) {
                if(park[i][j].equals("-1")) {
                    if(i >= 1 && j >= 1) {
                        int max = Math.max(map[i-1][j-1], Math.max(map[i-1][j], map[i][j-1]));
                        int min = Math.min(map[i-1][j-1], Math.min(map[i-1][j], map[i][j-1]));
                        
                        if(max == min) {
                            map[i][j] = max+1;
                        } else {
                            map[i][j] = min+1;
                        }
                    } else {
                        map[i][j] = 1;
                    }
                    range = Math.max(range, map[i][j]);
                }
            }
        }
        
        int answer = -1;
        for(int k : mats) {
            if(range >= k) {
                answer = Math.max(answer, k);
            }
        }
        
        return answer;
    }
}