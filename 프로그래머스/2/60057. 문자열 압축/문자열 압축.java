import java.util.*;

class Solution {
    public static int solution(String s) {
        int answer = 0;

        int n = s.length()/2;

        int min = Integer.MAX_VALUE;
        if(n == 0) {
            return 1;
        }

        for(int i = 1; i <= n; i++) {
            int a = i;
            int b = 1;

            StringBuilder sb = new StringBuilder();
            String str1 = s.substring(0, a);
            String str2 = "";

            while(a+i <= s.length()) {
                str2 = s.substring(a, a+i);

                if(str1.equals(str2)) {
                    b++;
                } else {
                    if(b > 1) {
                        sb.append(b).append(str1);
                        b = 1;
                        str1 = str2;
                    } else {
                        sb.append(str1);
                        str1 = str2;
                    }
                }
                a += i;
            }

            if(b > 1) {
                sb.append(b).append(str1);
            } else {
                sb.append(str2);
            }

            sb.append(s.substring(a));

            if(sb.length() < min) {
                min = sb.length();
            }
        }

        answer = min;

        return answer;
    }
}