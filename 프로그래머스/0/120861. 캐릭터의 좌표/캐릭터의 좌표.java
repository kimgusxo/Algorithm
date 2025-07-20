class Solution {
    public int[] solution(String[] keyinput, int[] board) {
        int[] answer = new int[2];
        
        int maxX = (board[0]-1)/2;
        int minX = -1*(board[0]-1)/2;
        int maxY = (board[1]-1)/2;
        int minY = -1*(board[1]-1)/2;
        
        for(String s : keyinput) {
            switch(s) {
                case "left": {
                    if(answer[0] > minX) {
                        answer[0]--;
                    }
                    break;
                }
                case "right": {
                    if(answer[0] < maxX) {
                        answer[0]++;
                    }
                    break;
                }
                case "up": {
                    if(answer[1] < maxY) {
                        answer[1]++;
                    }
                    break;
                }
                case "down": {
                    if(answer[1] > minY) {
                        answer[1]--;
                    }
                    break;
                }
            }
        }
        
        return answer;
    }
}