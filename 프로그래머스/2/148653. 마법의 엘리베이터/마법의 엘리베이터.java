class Solution {
    
    public int solution(int storey) {
        int answer = 0;

        boolean flag = false;
        String s = "0"+storey;
        for(int i = 1; i < s.length(); i++) {
            int el = Character.getNumericValue(s.charAt(s.length()-i));

            if(flag) {
                el++;
                flag = false;
            }

            if(el < 5) {
                answer += el;
            } else if(el > 5) {
                answer += (10-el);
                flag = true;
            } else {
                int prev = Character.getNumericValue(s.charAt(s.length()-i-1));
                if(prev < 5) {
                    answer += el;
                } else {
                    answer += (10-el);
                    flag = true;
                }
            }
        }

        return flag ? answer+1 : answer;
    }
}