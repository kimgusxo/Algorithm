import java.util.*;

class Solution {
    
    static Set<Integer> set = new HashSet<>();
    static int answer = 0;
    
    public int solution(String numbers) {
        String[] numberArray = numbers.split("");
        boolean[] visited = new boolean[numberArray.length];
        
        for(int i = 1; i <= numberArray.length; i++) {
            backtracking(numberArray, visited, i, new StringBuilder());
        }
        
        for(Integer el : set) {
            if(el > 1) {
                if(isPrime(el)) {
                    answer++;
                };
            }
        }
        
        return answer;
    }
    
    public static void backtracking(String[] numberArray, boolean[] visited,
                                    int digits, StringBuilder number) {
        if(number.length() == digits) {
            set.add(Integer.parseInt(number.toString()));
            return;
        }
        
        for(int i = 0; i < numberArray.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                number.append(numberArray[i]);
                
                backtracking(numberArray, visited, digits, number);
                
                number.deleteCharAt(number.length()-1);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(int num) {
        boolean flag = true;
        for(int i = 2; i <= (int) Math.sqrt(num); i++) {
            if(num%i == 0) {
                flag = false;
                break;
            }
        }
        
        return flag;
    }
}