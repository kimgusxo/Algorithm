import java.util.*;

class Solution {
    
    static int answer = 0;

    public int solution(int[] arrayA, int[] arrayB) {
        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int minA = arrayA[0];
        int minB = arrayB[0];

        answer = Math.max(answer, calc(arrayA, arrayB, minA));
        answer = Math.max(answer, calc(arrayB, arrayA, minB));

        return answer;
    }

    public static int calc(int[] arrA, int[] arrB, int val) {
        int result = 0;

        for(int i = val; i >= 2; i--) {
            boolean flag = true;
            for(int j = 0; j < arrA.length; j++) {
                if(arrA[j]%i != 0) {
                    flag = false;
                    break;
                }
                if(arrB[j]%i == 0) {
                    flag = false;
                    break;
                }
            }

            if(flag) {
                result = i;
                break;
            }
        }

        return result;
    }
}