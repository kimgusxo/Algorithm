class Solution {
    public int solution(String my_string) {
        int answer = 0;
        boolean flag = true;
        for(String s : my_string.split(" ")) {
            if(s.equals("+")) {
                flag = true;
            } else if(s.equals("-")) {
                flag = false;
            } else {
                if(flag) {
                    answer += Integer.parseInt(s);
                } else {
                    answer -= Integer.parseInt(s);
                }
            }
        }
        return answer;
    }
}