class Solution {
    
    static String[] babble = {"aya", "ye", "woo", "ma"};
    
    public int solution(String[] babbling) {
        int answer = 0;
        
        for(String b : babbling) {
            for(int i = 0; i < babble.length; i++) {
                b = b.replace(babble[i], String.valueOf(i));
            }
            
            boolean flag = false;
            if(b.matches("^[0-9]*$")) {
                char cur = ' ';
                for(char c : b.toCharArray()) {
                    if(cur == c) {
                        flag = true;
                        break;
                    }
                    cur = c;
                }
            } else {
                flag = true;
            }
            
            answer += flag ? 0 : 1;
        }
        
        return answer;
    }
}