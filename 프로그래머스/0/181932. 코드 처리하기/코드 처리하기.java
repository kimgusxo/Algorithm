class Solution {
    public String solution(String code) {
        String ret = "";
        int mode = 0;
        for (int idx=0; idx < code.length(); idx++){
            if (mode==0){
                if (code.charAt(idx) != '1'){   //짝수일 때
                    if (idx%2==0){ret = ret.concat(String.valueOf(code.charAt(idx)));}   
                }
                else if (code.charAt(idx) == '1'){ mode = 1;}
            } else if (mode==1){
                if (code.charAt(idx) != '1'){   //홀수일 때
                    if (idx%2!=0){ret = ret.concat(String.valueOf(code.charAt(idx)));}   
                }
                else if (code.charAt(idx) == '1'){mode = 0;}
            }
        }
        if (ret.length()==0){return "EMPTY";} 
        return ret;
    }
}