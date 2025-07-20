class Solution {
    public String solution(String polynomial) {
        int x = 0;
        int num = 0;

        for(String s : polynomial.split(" \\+ ")) {
            if(s.contains("x")) {
                if(s.charAt(0) == 'x') {
                    x++;
                } else {
                    x += Integer.parseInt(s.replace("x", ""));
                }
            } else {
                num += Integer.parseInt(s);
            }
        }

        String answer = "";
        if(x > 1 && num > 0) {
            answer = x+"x" + " + " + num;
        } else if(x > 0 && num > 0) {
            answer = "x" + " + " + num;
        } else if(x > 1 && num == 0) {
            answer = x+"x";
        } else if(x > 0 && num == 0) {
            answer = "x";
        } else {
            answer = String.valueOf(num);
        }
        
        return answer;
    }
}