class Solution {
    public int solution(int n) {
        int answer = 0;
    
        StringBuilder sb = new StringBuilder();
        answer = Integer.parseInt((sb.append(Integer.toString(n, 3)).reverse().toString()), 3);
        
        return answer;
    }
}