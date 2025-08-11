import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        int answer = 0;
        StringBuilder el = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        for(char c : line.toCharArray()) {
            if(c == '+') {
                queue.add(Integer.parseInt(el.toString()));
                el.setLength(0);
            } else if(c == '-') {
                queue.add(Integer.parseInt(el.toString()));
                el.setLength(0);
                el.append(c);
            } else {
                el.append(c);
            }
        }

        if(el.length() > 0) {
            queue.add(Integer.parseInt(el.toString()));
        }

        boolean flag = true;
        for(Integer i : queue) {
            if(i < 0) {
                flag = false;
            }
            if(flag) {
                answer += i;
            } else {
                answer -= Math.abs(i);
            }
        }

        System.out.println(answer);
    }
}



