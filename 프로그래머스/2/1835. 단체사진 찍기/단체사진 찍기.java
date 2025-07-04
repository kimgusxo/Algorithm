import java.io.*;
import java.util.ArrayList;

class Solution {

    static char[] chars = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};

    public int solution(int n, String[] data) {
        int answer = 0;

        ArrayList<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean[] visited = new boolean[chars.length];

        setUp(list, sb, visited);

        for(String line : list) {
            if(judge(line, data)) {
                answer++;
            }
        }

        return answer;
    }

    public static boolean judge(String line, String[] data) {
        for(String condition : data) {
            char c1 = condition.charAt(0);
            char c2 = condition.charAt(2);

            char sign = condition.charAt(3);

            int range = condition.charAt(4) - '0';

            int idx1 = line.indexOf(c1);
            int idx2 = line.indexOf(c2);

            int result = Math.abs(idx1-idx2)-1;

            switch (sign) {
                case '=': {
                    if(result != range) {
                        return false;
                    }
                    break;
                }
                case '>': {
                    if(result <= range) {
                        return false;
                    }
                    break;
                }
                case '<': {
                    if(result >= range) {
                        return false;
                    }
                    break;
                }
            }
        }
        return true;
    }

    public static void setUp(ArrayList<String> list, StringBuilder sb, boolean[] visited) {
        if(sb.length() == 8) {
            list.add(sb.toString());
            return;
        }

        for(int i = 0; i < chars.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                sb.append(chars[i]);
                setUp(list, sb, visited);
                visited[i] = false;
                sb.deleteCharAt(sb.length()-1);
            }
        }
    }
}