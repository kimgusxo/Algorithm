class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];

        int idx = 1;

        int x = 0;
        boolean xDir = false;
        int y = 0;
        boolean yDir = false;
        while(idx <= Math.pow(n, 2)) {
            if(!xDir && !yDir) {
                if(y == n || answer[x][y] != 0) {
                   yDir = true;
                   y--;
                   x++;
                } else {
                    answer[x][y++] = idx++;
                }
            } else if(!xDir) {
                if(x == n || answer[x][y] != 0) {
                    xDir = true;
                    x--;
                    y--;
                } else {
                    answer[x++][y] = idx++;
                }
            } else if(yDir) {
                if(y == -1 || answer[x][y] != 0) {
                    yDir = false;
                    y++;
                    x--;
                } else {
                    answer[x][y--] = idx++;
                }
            } else {
                if(x == -1 || answer[x][y] != 0) {
                    xDir = false;
                    x++;
                    y++;
                } else {
                    answer[x--][y] = idx++;
                }
            }
        }

        return answer;
    }}