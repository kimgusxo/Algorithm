import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        List<Integer> list = new ArrayList<>();
        for(int el : moves) {
            for(int i = 0; i < board.length; i++) {
                if(board[i][el-1] > 0) {
                    list.add(board[i][el-1]);
                    
                    if(list.size() >= 2) {
                        if(list.get(list.size()-1) == list.get(list.size()-2)) {
                            answer += 2;
                            list.remove(list.size()-1);
                            list.remove(list.size()-1);
                        }
                    }
                    
                    board[i][el-1] = 0;
                    break; 
                }
            }
        }
        
        return answer;
    }
}