class Solution {
        public int solution(int n) {
        int answer = 1;

        for(int i = 1; i <= n; i++) {
            int sum = i;
            int next = i+1;
            while(n >= sum) {
                sum += next;
                if(sum == n) {
                    answer++;
                    break;
                }
                next++;
            }
        }

        return answer;
    }
}