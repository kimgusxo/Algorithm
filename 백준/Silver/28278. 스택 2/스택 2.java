import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            switch (num) {
                case 1: {
                    int val = Integer.parseInt(st.nextToken());
                    stack.push(val);
                    break;
                }
                case 2: {
                    if (!stack.isEmpty()) {
                        ans.append(stack.pop()).append("\n");
                    } else {
                        ans.append(-1).append("\n");
                    }
                    break;
                }
                case 3: {
                    ans.append(stack.size()).append("\n");
                    break;
                }
                case 4: {
                    if (!stack.isEmpty()) {
                        ans.append(0).append("\n");
                    } else {
                        ans.append(1).append("\n");
                    }
                    break;
                }
                case 5: {
                    if (!stack.isEmpty()) {
                        ans.append(stack.peek()).append("\n");
                    } else {
                        ans.append(-1).append("\n");
                    }
                    break;
                }
                default: {
                    break;
                }
            }
        }
        System.out.print(ans);
    }
}
