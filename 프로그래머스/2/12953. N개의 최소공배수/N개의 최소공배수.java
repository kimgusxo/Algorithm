import java.util.*;

class Solution {
    public int solution(int[] arr) {
    
        Map<Integer, Integer> primeMap = new HashMap<>();
        for(int el : arr) {
            int idx = 2;
            Map<Integer, Integer> prime = new HashMap<>();
            while(el != 1) {
                if(el%idx == 0) {
                    el /= idx;
                    prime.put(idx, prime.getOrDefault(idx, 0)+1);
                    idx = 2;
                } else {
                    idx++;
                }
            }
            
            for(Integer key : prime.keySet()) {
                if(prime.get(key) > primeMap.getOrDefault(key, 0)) {
                    primeMap.put(key, prime.get(key));
                }
            }
        }
        
        int answer = 1;
        for(Integer key : primeMap.keySet()) {
            answer *= (int) Math.pow(key, primeMap.get(key));
        }
        return answer;
    }
}