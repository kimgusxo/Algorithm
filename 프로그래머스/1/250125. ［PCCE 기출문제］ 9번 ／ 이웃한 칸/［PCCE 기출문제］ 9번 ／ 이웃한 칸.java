class Solution {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        String color = board[h][w];
        for(int j = 0; j < dx.length; j++) {
            int nx = h + dx[j];
            int ny = w + dy[j];
            if(nx >= 0 && nx < board.length &&
               ny >= 0 && ny < board[0].length) {
                if(color.equals(board[nx][ny])) {
                    answer++;
                }
            }
        }
        
        return answer;
    }
}