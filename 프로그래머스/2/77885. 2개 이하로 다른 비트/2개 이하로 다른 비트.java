class Solution {
    
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        int i = 0;
        for(long n : numbers) {
            long k = n%4;
            
            if(k == 3) {
                int exp = 0;
            
                for(int j = 0; j < 64; j++) {
                    long range = 1L << j;
                    if(range > n) {
                        exp = j;
                        break;
                    }
                }
                
                for(long j = 2; j <= (long) Math.pow(2, exp); j *= 2) {
                    long el = n^(n+j);
                    if (Long.bitCount(el) <= 2) {
                        answer[i] = n + j;
                        break;
                    }
                    
                }
                
            } else {
                answer[i] = n+1;                
            }
            i++;
        }
        
        return answer;
    }
}