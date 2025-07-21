class Solution {
    public int solution(int i, int j, int k) {
        int answer = 0;
        for(int x = i; x <= j; x++) {
            if(String.valueOf(x).contains(k+"")) {
                for(char c : (x+"").toCharArray()) {
                    if(k == Character.getNumericValue(c)) {
                        answer++;
                    }
                }
            }
        }
        return answer;
    }
}