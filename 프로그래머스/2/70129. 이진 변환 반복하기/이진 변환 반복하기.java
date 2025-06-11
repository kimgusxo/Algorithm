import java.util.stream.Collectors;

class Solution {
    public int[] solution(String s) {
        int[] answer = new int[2];

        StringBuilder sb = new StringBuilder(s);

        int zero = 0;
        int repeat = 0;

        while(sb.length() > 1) {
            zero += (int) sb.chars().filter(ch -> ch == '0').count();
            int binary = sb.chars()
                    .filter(ch -> ch != '0')
                    .mapToObj(ch -> String.valueOf((char) ch))
                    .collect(Collectors.joining())
                    .length();

            sb = new StringBuilder(Integer.toString(binary, 2));

            repeat++;
        }

        answer[0] = repeat;
        answer[1] = zero;

        return answer;
    }
}