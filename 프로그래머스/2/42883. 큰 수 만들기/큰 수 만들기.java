class Solution {
    
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        int length = number.length() - k;
        
        while(sb.length() < length) {
            for(int i = 9; i >= 0; i--) {
                int idx = number.indexOf(i+"");
                
                if(idx >= 0) {
                    if(number.length()-idx >= length-sb.length()) {
                        number = number.substring(idx+1, number.length());
                        sb.append(i);
                        break;
                    }
                }
            }
        }
        
        return sb.toString();
    }
}