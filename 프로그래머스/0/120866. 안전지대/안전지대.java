class Solution {
    
    static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
    
    public int solution(int[][] board) {
        int answer = 0;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(board[i][j] == 1) {
                    if(!visited[i][j]) {
                        visited[i][j] = true;
                        answer++;
                    }
                    for(int k = 0; k < dx.length; k++) {
                        int nx = i+dx[k];
                        int ny = j+dy[k];
                        if(nx >= 0 && nx < board.length && ny >= 0 && ny < board[0].length && !visited[nx][ny]) {
                            visited[nx][ny] = true;
                            answer++;
                        }
                    }
                }
            }
        }
        return (board.length*board[0].length)-answer;
    }
}