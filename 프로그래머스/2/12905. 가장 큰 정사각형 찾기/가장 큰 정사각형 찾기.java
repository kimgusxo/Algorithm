class Solution {
    public int solution(int[][] board) {
        int answer = 0;

        for (int[] row : board) {
            for (int v : row) {
                if (v == 1) {
                    answer = 1;
                    break;
                }
            }
        }

        for(int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[0].length; j++) {
                if(board[i][j] > 0) {
                    if(board[i-1][j-1] > 0 && board[i-1][j] > 0 && board[i][j-1] > 0) {
                        board[i][j] = Math.min(Math.min(board[i-1][j], board[i][j-1]),board[i-1][j-1])+1;
                        answer = Math.max(answer, board[i][j]);
                    }
                }
            }
        }

        return answer*answer;
    }
}