import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        String expr = br.readLine();

        ArrayList<Integer> charToNum = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            charToNum.add(Integer.parseInt(br.readLine()));
        }

        Stack<Double> stack = new Stack<>();

        for(char c : expr.toCharArray()) {
            if(String.valueOf(c).matches("[A-Z]")) {
                stack.push(Double.valueOf(charToNum.get(c-'A')));
            } else {
                double val1 = stack.pop();
                double val2 = stack.pop();

                switch(c) {
                    case '+': stack.push(val2 + val1); break;
                    case '-': stack.push(val2 - val1); break;
                    case '*': stack.push(val2 * val1); break;
                    case '/': stack.push(val2 / val1); break;
                }
            }
        }

        System.out.println(String.format("%.2f", stack.pop()));
    }
}