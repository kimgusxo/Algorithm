class Solution {
    public int solution(String binomial) {
        String[] op = binomial.split(" ");
        
        int answer = 0;
        int op1 = Integer.parseInt(op[0]);
        String op2 = op[1];
        int op3 = Integer.parseInt(op[2]);
        
        
        switch(op2) {
            case "+":
                answer = op1+op3;
                break;
            case "-":
                answer = op1-op3;
                break;
            case "*":
                answer = op1*op3;
                break;
        }
        
        return answer;
    }
}