class Solution {
    boolean solution(String s) {
        boolean answer = true;

        int p, y = 0;
        
        StringBuilder sb = new StringBuilder(s.toLowerCase());
        
        p = (int) sb.chars().filter(c -> c == 'p').count();
        y = (int) sb.chars().filter(c -> c == 'y').count();
        
        if(p != y) {
            answer = false;
        }

        return answer;
    }
}