import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int start = 1;

        boolean flag = true;

        for(int i = 0; i < N; i++) {
            int el = Integer.parseInt(br.readLine());

            if(stack.isEmpty()) {
                while(start <= el) {
                    stack.push(start);
                    start++;
                    sb.append("+"+"\n");
                }
                stack.pop();
                sb.append("-"+"\n");
            } else {
                int top = stack.peek();
                if(top == el) {
                    stack.pop();
                    sb.append("-"+"\n");
                } else if(start <= el) {
                    while(start <= el) {
                        stack.push(start);
                        start++;
                        sb.append("+"+"\n");
                    }
                    stack.pop();
                    sb.append("-"+"\n");
                } else {
                    flag = false;
                }
            }
        }

        if(flag) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}