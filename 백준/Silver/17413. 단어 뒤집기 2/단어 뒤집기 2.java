import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();

        Deque<Character> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        boolean flag = false;

        for(char c : line.toCharArray()) {
            deque.add(c);

            if(c == '<') {
                char temp = deque.removeLast();
                while(!deque.isEmpty()) {
                    sb.append(deque.removeLast());
                }
                sb.append(temp);
                flag = true;
            }

            if(c == '>') {
                while(!deque.isEmpty()) {
                    sb.append(deque.removeFirst());
                }
                flag = false;
            } else if(c == ' ' && !flag) {
                char temp = deque.removeLast();
                while(!deque.isEmpty()) {
                    sb.append(deque.removeLast());
                }
                sb.append(temp);
            }
        }

        if(flag) {
            while(!deque.isEmpty()) {
                sb.append(deque.removeFirst());
            }
        } else {
            while(!deque.isEmpty()) {
                sb.append(deque.removeLast());
            }
        }

        System.out.println(sb);
    }
}