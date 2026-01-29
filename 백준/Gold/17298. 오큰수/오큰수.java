import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] arr = br.readLine().split(" ");

        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(Integer.parseInt(arr[N-1]));

        Deque<String> result = new ArrayDeque<>();
        result.push("-1");

        for(int i = N-2; i >= 0; i--) {
            while(true) {
                if(stack.isEmpty()) {
                    stack.push(Integer.parseInt(arr[i]));
                    result.push("-1");
                    break;
                } else {
                    if(stack.peek() > Integer.parseInt(arr[i])) {
                        result.push(String.valueOf(stack.peek()));
                        stack.push(Integer.parseInt(arr[i]));
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!result.isEmpty()) {
            sb.append(result.pop()).append(" ");
        }
        System.out.println(sb);
    }
}