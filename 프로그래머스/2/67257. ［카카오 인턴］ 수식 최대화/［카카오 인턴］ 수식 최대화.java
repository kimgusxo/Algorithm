import java.util.*;

class Solution {

    static long answer = 0;
    static String[][] array = {
            {"*","+","-"},{"*","-","+"},
            {"+","-","*"},{"+","*","-"},
            {"-","*","+"},{"-","+","*"}
    };

    public long solution(String expression) {
        Deque<String> queue = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(String s : expression.split("")) {
            if(s.equals("*")) {
                queue.add(sb.toString());
                queue.add("*");
                sb = new StringBuilder();
            } else if(s.equals("+")) {
                queue.add(sb.toString());
                queue.add("+");
                sb = new StringBuilder();
            } else if(s.equals("-")) {
                queue.add(sb.toString());
                queue.add("-");
                sb = new StringBuilder();
            } else {
                sb.append(s);
            }
        }
        queue.add(sb.toString());

        calc(queue);

        return answer;
    }

    public static void calc(Deque<String> queue) {
        for(int i = 0; i < array.length; i++) {
            Deque<String> origin = new ArrayDeque<>(queue);
            for(int j = 0; j < array[0].length; j++) {
                Deque<String> temp = new ArrayDeque<>();
                String op = array[i][j];

                while(!origin.isEmpty()) {
                    String e = origin.poll();
                    if(e.equals(op)) {
                        String e1 = temp.removeLast();
                        String e2 = origin.poll();

                        switch(e) {
                            case "+":
                                temp.add(String.valueOf(Long.parseLong(e1)+Long.parseLong(e2)));
                                break;
                            case "*":
                                temp.add(String.valueOf(Long.parseLong(e1)*Long.parseLong(e2)));
                                break;
                            case "-":
                                temp.add(String.valueOf(Long.parseLong(e1)-Long.parseLong(e2)));
                                break;
                        }
                    } else {
                        temp.offer(e);
                    }
                }
                origin = new ArrayDeque<>(temp);
            }
            answer = Math.max(answer, Math.abs(Long.parseLong(origin.poll())));
        }
    }
}