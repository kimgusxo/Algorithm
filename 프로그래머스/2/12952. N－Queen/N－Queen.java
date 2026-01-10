class Solution {
    
    static int answer = 0;

    public int solution(int n) {
        int[][] map = new int[n][n];
        solve(0, n, map);
        return answer;
    }

    private static boolean isSafe(int row, int col, int n, int[][] map) {
        // 위쪽만 확인
        for(int i = 0; i < row; i++) {
            if(map[i][col] == 1) {
                return false;
            }
        }

        // 위쪽 왼쪽 대각선 확인
        for(int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if(map[i][j] == 1) {
                return false;
            }
        }

        // 위쪽 오른쪽 대각선 확인
        for(int i = row, j = col; i >= 0 && j < n; i--, j++) {
            if(map[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    private static void solve(int row, int n, int[][] map) {
        if(row == n) {
            answer++;
            return;
        }

        for(int col = 0; col < n; col++) {
            if(isSafe(row, col, n, map)) {
                map[row][col] = 1;
                solve(row+1, n, map);
                map[row][col] = 0;
            }
        }
    }
}