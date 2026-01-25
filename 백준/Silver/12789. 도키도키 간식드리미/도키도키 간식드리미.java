import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            queue.offer(Integer.parseInt(st.nextToken()));
        }

        int complete = 1;
        while(complete < N) {
            if(!queue.isEmpty()) {
                if(queue.peek() == complete) {
                    queue.poll();
                    complete++;
                } else {
                    if(!stack.isEmpty() && stack.peek() == complete) {
                        stack.pop();
                        complete++;
                    } else {
                        stack.push(queue.poll());
                    }
                }
            } else {
                if(!stack.isEmpty()) {
                    if(stack.peek() == complete) {
                        stack.pop();
                        complete++;
                    } else {
                        System.out.println("Sad");
                        break;
                    }
                }
            }
        }

        if(complete == N) {
            System.out.println("Nice");
        }
    }
}