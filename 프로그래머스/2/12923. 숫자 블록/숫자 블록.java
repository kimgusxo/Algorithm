class Solution {
    
    static final int finish = 10_000_000;
    
    public int[] solution(long begin, long end) {
        int n = Math.toIntExact(end - begin);
        int[] answer = new int[n+1];

        for(int i = 0; i <= n; i++) {
            answer[i] = 1;
            int num = Math.toIntExact(begin + i);
            int range = (int) Math.sqrt(num);
            for(int j = 2; j <= range; j++) {
                if(num%j == 0) {
                    if(num/j <= finish) {
                        answer[i] = num/j;
                        break;
                    } else if(j <= finish) {
                        answer[i] = j;
                    }
                }
            }
        }

        if(begin == 1) {
            answer[0] = 0;
        }

        return answer;
    }
}