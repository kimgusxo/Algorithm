class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        for(int i = 0; i < targets.length; i++) {
            for(char c : targets[i].toCharArray()) {
                int score = Integer.MAX_VALUE;
                int temp = 0;
                for(int j = 0; j < keymap.length; j++) {
                    temp = keymap[j].indexOf(String.valueOf(c));
                    if(temp > -1) {
                        score = Math.min(temp, score);
                    }
                }
                if(score == Integer.MAX_VALUE) {
                    answer[i] = -1;
                    break;
                } else {
                    answer[i] += score+1;
                }
            }
        }
        
        return answer;
    }
}