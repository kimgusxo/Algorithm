import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line =  br.readLine();
        Deque<String> left = new ArrayDeque<>();
        Deque<String> right = new ArrayDeque<>();

        for(String ch : line.split("")) {
            left.push(ch);
        }

        int command = Integer.parseInt(br.readLine());

        for(int i = 0; i < command; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String com =  st.nextToken();

            switch(com) {
                case "P":
                    String ch = st.nextToken();
                    left.push(ch);
                    break;
                case "L":
                    if(!left.isEmpty()) {
                        right.push(left.pop());
                    }
                    break;
                case "D":
                    if(!right.isEmpty()) {
                        left.push(right.pop());
                    }
                    break;
                case "B":
                    if(!left.isEmpty()) {
                        left.pop();
                    }
                    break;
            }
        }

        StringBuilder result = new StringBuilder();
        while(!left.isEmpty()) {
            result.append(left.pollLast());
        }
        while(!right.isEmpty()) {
            result.append(right.pollFirst());
        }

        System.out.println(result.toString());
    }
}